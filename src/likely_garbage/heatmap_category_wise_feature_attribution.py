import numpy as np
import pandas as pd
import sys
import seaborn as sns
import matplotlib.pyplot as plt
import csv
import os

def is_correct(predicted, true, target_category):
    # Remove square brackets and convert to integer
    predicted = int(predicted.strip('[]'))
    #if predicted == true == target_category:
    #    print(predicted, true, target_category)
    return predicted == true == target_category

def countPredictionCorrectly(filename, target_category):
    correct_tests=0
    with open(filename, 'r') as file:
        check_next_line = False  # Flag to indicate if the next line should be checked
        for line in file:
            line = line.strip()
            if line.startswith('#Test='):
                check_next_line = True  # Next line is a data line that needs to be checked
            elif line and not line.startswith('Token,Attribution') and check_next_line:
                # Split the line and check the condition
                parts = line.split(',')
                #print(line)
                if len(parts) == 5:  # Ensure it's a valid data line
                    predicted_class = parts[2]
                    true_class = int(parts[3])

                    if is_correct(predicted_class, true_class, int(target_category)):
                        correct_tests += 1
                    check_next_line = False 
    return correct_tests

#def sum_top_k(scores):
#    return scores.nlargest(10).sum() #means that we are only considering top-k = 10 or 5 occurances of the tokens
TOP_K_Tokens_FROM_EACH_TEST = 10
def get_top_tokens_from_csv(csv_file_path, fold, count, feature_grp="most_important_features"):
    with open(csv_file_path, 'r') as file:
        reader = csv.reader(file, quotechar='"', delimiter=',', skipinitialspace=True)
        lines = list(reader) 
        #lines = file.readlines() 
    result = {}
    test_data = []
    current_test = None
    for line in lines:
        if line[0].startswith('#Test='):
            if current_test:
                # Process the previous test data if it meets the criteria
                df = pd.DataFrame(test_data[1:], columns=test_data[0])
                df['Attribution'] = pd.to_numeric(df['Attribution'])
                predicted_class = df['Predicted_class'].iloc[0].strip('[]')
                true_class = df['True_class'].iloc[0]
                pred_logit = df['Test_Pred_logit'].iloc[0]
                confidence_score = df['Test_confidence_score'].iloc[0]
                # Check if Predicted_class and True_class are the same
                if all(df['Predicted_class'] == f'[{true_class}]') and all(df['True_class'] == true_class):
                    count +=1
                    #top_tokens = df.nlargest(3, 'Attribution')['Token'].tolist()
                    if feature_grp == "most_important_features":
                        top_tokens_df = df.nlargest(TOP_K_Tokens_FROM_EACH_TEST, 'Attribution')[['Token', 'Attribution']]
                    elif feature_grp == "least_important_features":
                        top_tokens_df = df.nsmallest(TOP_K_Tokens_FROM_EACH_TEST, 'Attribution')[['Token', 'Attribution']]

                    top_tokens = top_tokens_df['Token'].tolist()
                    top_attributions = top_tokens_df['Attribution'].tolist()
                    result[current_test] = {
                        'Top_Tokens': top_tokens,
                        'Attributions': top_attributions,
                        'Predicted_Class': predicted_class,
                        'True_Class': true_class,
                        'Test_Pred_Logit': pred_logit,
                        'Test_confidence_score': confidence_score
                    }
            #current_test = str(fold)+"_"+line.strip().split('=')[1]
            current_test = str(fold) + "_" + line[0].strip().split('=')[1]  # Keep track of current test

            test_data = []
        else:
            #test_data.append(line.strip().split(','))
            test_data.append(line)
    
    if current_test and test_data: #handles the processing of the last test data block after the end of the file.
        df = pd.DataFrame(test_data[1:], columns=test_data[0])
        df['Attribution'] = pd.to_numeric(df['Attribution'])
        predicted_class = df['Predicted_class'].iloc[0].strip('[]')
        true_class = df['True_class'].iloc[0]
        pred_logit = df['Test_Pred_logit'].iloc[0]
        confidence_score = df['Test_confidence_score'].iloc[0]
        # Check if Predicted_class and True_class are the same
        if all(df['Predicted_class'] == f'[{true_class}]') and all(df['True_class'] == true_class):
            count +=1
            #top_tokens_df = df.nlargest(TOP_K_Tokens_FROM_EACH_TEST, 'Attribution')[['Token', 'Attribution']]
            if feature_grp == "most_important_features":
                top_tokens_df = df.nlargest(TOP_K_Tokens_FROM_EACH_TEST, 'Attribution')[['Token', 'Attribution']]
            elif feature_grp == "least_important_features":
                bottom_tokens_df = df.nsmallest(TOP_K_Tokens_FROM_EACH_TEST, 'Attribution')[['Token', 'Attribution']]
            top_tokens = top_tokens_df['Token'].tolist()
            top_attributions = top_tokens_df['Attribution'].tolist()
            #print('2nd IF***')
            result[current_test] = {
                'Top_Tokens': top_tokens,
                'Attributions': top_attributions,
                'Predicted_Class': predicted_class,
                'True_Class': true_class,
                'Test_Pred_Logit': pred_logit,
                'Test_confidence_score': confidence_score
            } 
    return result, count

#def get_top_tokens(data):
#    tests = data.split('#Test=')[1:]
#    print(tests)
#    exit()
#    result = {}
#    for test in tests:
#        lines = test.strip().split('\n')
#        test_id = lines[0].strip()
#        df = pd.read_csv(StringIO('\n'.join(lines[1:])))
#        top_tokens = df.nlargest(3, 'Attribution')['Token'].tolist()
#        result[test_id] = top_tokens
#    return result

def filter_predicted_class_based_category(data, category): # to get only the given category specific tests
    return {key: value for key, value in data.items() if value['Predicted_Class'] == category}

def calculate_uniq_token_and_scores(data, feature_grp="most_important_features"):
    #print(data)
    #print(type(data))
    token_attributions = {}
    token_counts = {}
    test_uniq_token_counts = {}
    blacklist = {"public", "assert", "Test", "void", "new", "iterations", "Equals", "Assert", "That", "test", "String", "new", "throws", "For", "Exception", "True", "With", "as", "1", "is", "class", "Token"}  # Add any tokens you want to exclude
    # Iterate over each entry in the data
    for entry in data:
        tokens = entry['Top_Tokens']
        attributions = entry['Attributions']
        model_confidence_score = entry['Test_confidence_score']
        #print('model_confidence_score=', str(model_confidence_score))
        unique_tokens_in_test = set()
        # Accumulate attributions for each token
        for token, attribution in zip(tokens, attributions):
            if token in blacklist:
                continue
            if token in token_attributions:
                #if token == "Thread":
                #    print('attribution=', str(attribution))
                attribution *= float(model_confidence_score)  # Multiply the attribution by model confidence score
                token_attributions[token] += attribution
                token_counts[token] += 1 
            else:
                token_attributions[token] = attribution
                token_counts[token] = 1
        
            unique_tokens_in_test.add(token)
 
        for token in unique_tokens_in_test:
            if token in test_uniq_token_counts:
                test_uniq_token_counts[token] += 1
            else:
                test_uniq_token_counts[token] = 1 
    #df_token_attributions = pd.DataFrame(list(token_attributions.items()), columns=['Token', 'Total_Attribution'])
    df_token_attributions = pd.DataFrame({
        'Token': token_attributions.keys(),
        'Total_Attribution': token_attributions.values(),
        'Count': token_counts.values(),
        'Unique_Token_Count_In_Each_Test': [test_uniq_token_counts[token] for token in token_attributions.keys()]
    })
    #return df_token_attributions.sort_values(by='Total_Attribution', ascending=False)
    if feature_grp == "most_important_features":
        return df_token_attributions.sort_values(by='Unique_Token_Count_In_Each_Test', ascending=False)
    else:
        return df_token_attributions.sort_values(by='Unique_Token_Count_In_Each_Test')
    #exit()

if __name__ == "__main__":
    #per_fold_file_for_a_category = sys.argv[1]
    outputCsvFile = sys.argv[1]
    outputHeatmapPng = sys.argv[2]
    category = sys.argv[3]
    dataset_name = sys.argv[4]
    attributions_dir = sys.argv[5]
    feature_grp = sys.argv[6]
    predicted_test_correctly = 0
    #df = pd.read_csv(sys.argv[1]) 
    #top_tokens = get_top_tokens(df)

    count=0    
    all_data = []
    for fold in range(5):
        per_fold_file_for_a_category = attributions_dir+"detokenization/"+dataset_name+"_"+str(category)+"_fold_"+str(fold)+".csv"
        top_tokens, count = get_top_tokens_from_csv(per_fold_file_for_a_category, fold, count, feature_grp)
        
        filtered_top_tokens = filter_predicted_class_based_category(top_tokens, category)    
        for test_id, data in filtered_top_tokens.items():
            all_data.append(data)
        #print('****')
        #print(all_data)
    sorted_df_token_attributions = calculate_uniq_token_and_scores(all_data, feature_grp)
    #print(sorted_df_token_attributions)
    #exit()
    sorted_df_token_attributions.to_csv(outputCsvFile, index=False)
    x=0
    #sorted_df_token_attributions['Normalized_Attribution'] = np.log(sorted_df_token_attributions['Total_Attribution'] +x)

    portion=10
    #top_50_percent = int(len(sorted_df_token_attributions) * portion/100)
    #top_data = sorted_df_token_attributions.head(top_50_percent)
    top_data = sorted_df_token_attributions.head(portion)
    
    top_data.to_csv('l', index=False)
    top_data = top_data[['Token', 'Count']]  # Exclude non-numeric columns
    #top_data = top_data[['Token', 'Total_Attribution']]  # Exclude non-numeric columns
    top_data['Count'] = top_data['Count'].astype(float) #* top_data['Count'].astype(float)
    print(top_data)
    #top_data['Attribution'] = top_data['Attribution'].astype(float)
    plt.figure(figsize=(10, 14))
    ax = sns.heatmap(top_data.set_index('Token'), annot=True, fmt=".2f", cmap='coolwarm', cbar=True, annot_kws={"size": 20})
    ax.set_title('Top 10 Tokens Attribution Heatmap', fontsize=20)

    # Increase font size for axes ticks
    ax.tick_params(axis='x', labelsize=20)  # Set x-axis label sizes
    ax.tick_params(axis='y', labelsize=20) 
    categories_map = {
        0 : "async wait",
        1 : "concurrency",
        2 : "time",
        3 : "unordered collection",
        4 : "order dependent test",
        5 : "non-flaky"
    }

    ax.set_title('Top 10 Tokens Attribution Heatmap', fontsize=20)

    # Increase font size for axes labels
    #ax.set_xlabel('Attribution Scores', fontsize=20)  # Set x-axis label with increased font size
    ax.set_ylabel('Tokens', fontsize=20)  
    #print(category)
    #plt.title('Top '+ str(portion)+' token Attribution Heatmap, Predicted category=['+categories_map.get(int(category), "Unknown category")+']')
    #plt.xlabel('Attribution Scores', labelsize = 20)  # Since there is only one column to plot
    #plt.ylabel('Tokens', labelsize = 20)
    plt.savefig(outputHeatmapPng, dpi=300)
    #plt.close('all') 
    plt.close() 
