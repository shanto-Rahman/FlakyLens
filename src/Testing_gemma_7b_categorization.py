import time
import torch
from transformers import AutoTokenizer, AutoModelForCausalLM
from huggingface_hub import login
import sys
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, gemma7b_model_define, codegemma7b_model_define, parse_category_and_token_list
import pandas as pd
import os
import numpy as np
import json
from sklearn.metrics import confusion_matrix, classification_report
import re
from collections import Counter

#login(token="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")
login(token="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")

timeStart = time.time()


def parse_generated_output_to_get_category(output_text):
    # Find all occurrences of "Category:"
    matches = re.findall(r"Category:\s*([^\n]*)", output_text)
    
    if matches:
        output_category = matches[-1].strip()  # Take the last occurrence
        output_category = re.sub(r"^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "", output_category)  # Remove non-alphanumeric chars at start/end
        #output_category = re.sub(r"^\s+", "", output_category)  # Explicitly remove leading spaces
        #output_category = output_category.replace("\xa0", "").replace("\u200b", "")


        #output_category = output_category.lstrip()  # Take the last occurrence
    else:
        output_category = "Unknown"

    print(len(output_category))  # Should be the exact length of "Concurrency" (11)
    print(repr(output_category))  # To see hidden characters
    print(f">>>{output_category}<<<")  # This will show if there are hidden spaces

    print("*****Extracted Category:",output_category)
    
    return output_category 
#def parse_generated_output_to_get_category(output_text):
#    print("***************")
#    print(output_text)
#    print("***************")
#    match = re.search(r"Category:\s*([^\n]*)", output_text)
#
#    if match:
#        output_category = match[-1].strip() # Take the last occurrence
#    else:
#        output_category = "Unknown"
#    
#    print("****Extracted Category:", output_category)
#    return output_category
#    ## Finding the start of the relevant output after "Answer:"
#    #answer_index = output.find("Category:")
#    #if answer_index == -1:
#    #    return "No Category section found", []
#
#    ## Slice the output to only consider text after "Answer:"
#    #relevant_output = output[answer_index:]
#
#    ## Regex to extract text within backticks following "Answer:"
#    #category_tokens_text = re.search(r"```\s*(.+?)\s*```", relevant_output, re.DOTALL)
#    #if not category_tokens_text:
#    #    return "Format error: No data found in expected format", []
#
#    ## Split the content by lines and extract relevant parts
#    #content_lines = category_tokens_text.group(1).strip().split('\n')
#    #category_line = next((line for line in content_lines if line.startswith("Category:")), None)
#    ##tokens_line = next((line for line in content_lines if line.startswith("Tokens:")), None)
#
#    #if not category_line:
#    #    return "Missing category or tokens", []
#
#    ## Extract category and tokens
#    #category = category_line.split(":", 1)[1].strip()
#    ##tokens = re.findall(r'"([^"]+)"', tokens_line)
#
#    #return category

def give_test_data_in_chunks(x_test_nparray, tokenizer, model, batch_size, device, fold, y_test_nparray): #BERT
    print('FROM GEMMA')
    max_length = 512
    x_test_df = pd.DataFrame(x_test_nparray)
    n = 1 #len(x_test) / batch_size
    preds_chunks = None
    paired_data = []
    model.eval()
    total_attributions = []
    total_tokens = []
    total_preds = []
    vis_data_records_ig = []
    top_tokens_per_test = []
    category_token_map = {}  # Dictionary to store tokens per category
    count = 0
    categories = {
    "async wait": 0,
    "concurrency": 1,
    "time": 2,
    "unordered collection": 3,
    "order dependent test": 4,
    "not flaky": 5
    }

    y_test_df = pd.DataFrame(y_test_nparray, columns=['category'])  # Convert to DataFrame
    for index, (test_data, actual_label) in enumerate(zip(x_test_df['full_code'], y_test_df['category'])):
    #for index, row in x_test_df.iterrows():
        #test_data = row['full_code']

        template=f"""You are an expert at identifying flaky tests and analyzing their type. Flaky tests are tests that pass and fail non-deterministically for the same code. You are given a test, and you have to check whether it is flaky or not. If it is flaky, you have to identify the type of flakiness and classify into one of the following categories or just say Not Flaky: 1. Async wait: The test execution makes an asynchronous call and does not properly wait for the result of the call to be available before proceeding. This can lead to non-deterministic test outcomes. 2. Concurrency: Test non-determinism is due to different threads interacting in a non-desirable manner (but not due to asynchronous calls from the Async Wait category), e.g., due to data races, atomicity violations, or deadlocks. 3. Time: Relying on the system time introduces non-deterministic failures, e.g., a test may fail when the midnight changes in the UTC time zone. Some tests also fail due to the precision by which time is reported as it can vary from one platform to another. 4. Unordered collection: In general, when iterating over unordered collections (e.g., sets), the code should not assume that the elements are returned in a particular order. If it does assume, the test outcome can become non-deterministic as different executions may have a different order. 5. Test Order dependent test: The test depends on the order of execution of other tests. If the order changes, the test outcome may change. 6. Not Flaky: The test is not flaky due to the above reasons.

        Test:
        {test_data}

        The output should be only the category name
        CATEGORY:"""

        definitions = f"""You are an expert at identifying flaky tests and analyzing their type. Flaky tests are tests that pass and fail non-deterministically for the same code. You are given a test, and you have to check whether it is flaky or not. If it is flaky, you have to identify the type of flakiness and classify into one of the following categories or just say Not Flaky: 
        1. Async wait: The test execution makes an asynchronous call and does not properly wait for the result of the call to be available before proceeding. This can lead to non-deterministic test outcomes. 
        2. Concurrency: Test non-determinism is due to different threads interacting in a non-desirable manner (but not due to asynchronous calls from the Async Wait category), e.g., due to data races, atomicity violations, or deadlocks. 
        3. Time: Relying on the system time introduces non-deterministic failures, e.g., a test may fail when the midnight changes in the UTC time zone. Some tests also fail due to the precision by which time is reported as it can vary from one platform to another. 
        4. Unordered collection: In general, when iterating over unordered collections (e.g., sets), the code should not assume that the elements are returned in a particular order. If it does assume, the test outcome can become non-deterministic as different executions may have a different order. 
        5. Test Order dependent test: The test depends on the order of execution of other tests. If the order changes, the test outcome may change. 
        6. Not Flaky: The test is not flaky due to the above reasons."""
        prompt = f"""
        Classify the given test as one of the following categories: Async wait or Concurrency or Time or Unordered collection or Order dependent test or non-flaky.
        Test:
        {test_data}                        
        **Output Format (MUST follow this format exactly):**
        ```
        Category: <one of the six categories above>
        ``` 
        """
        #prompt = f"""
        #Classify the given test as one of the following categories: **Async wait, Concurrency, Time, Unordered collection, Order dependent test, or Not Flaky**.
        #
        #**Test:**
        #{test_data}                        
        #
        #**Output Format (MUST follow this format exactly):**
        #```
        #Category: <one of the six categories above>
        #Tokens: ["token1", "token2", "token3", "token4", "token5"]
        #```
        #
        #**Important Rules:**
        #- **Category**: Choose exactly one from the given list.
        #- **Tokens**:
        #    - Provide exactly **5 tokens**.
        #    - Each token must be **a single atomic unit** (one word, number, or symbol).
        #    - **Do NOT include dots (`.`), spaces, or compound words**.  
        #    - **Example of valid tokens:** `"Thread"`, `"sleep"`, `"1000"`, `";"`, `"wait"`  
        #    - **Example of INVALID tokens (DO NOT use these!):** `"Thread.sleep"`, `"e.execute"`, `"this.method"`, `"Thread start"`

        #**Example of Expected Output:**
        #```
        #Category: Concurrency
        #Tokens: ["Thread", "lock", "synchronized", "race", "volatile"]
        #```

        #**Example of INVALID Output (DO NOT produce this format!):**
        #```
        #Category: Concurrency
        #Tokens: ["Thread.sleep", "e.execute", "Thread.start", "race condition", "lock()"]
        #```
        #"""
        MAX_LENGTH = 2048  # Or 8192, based on your model
        input_ids = tokenizer(prompt, return_tensors="pt", max_length=MAX_LENGTH, truncation=True).to(model.device)
        outputs = model.generate(**input_ids, max_new_tokens=10, return_dict_in_generate=True)
        print("outputs=", outputs)
        output_category = tokenizer.decode(outputs[0], skip_special_tokens=True)

        print("category_output=", output_category)

        exit()
        #category, tokens = parse_category_and_token_list(output_category)
        #category_value = categories.get(category.lower().strip(), 6)  # Return -1 if category not found
        #print(category_value)
        #total_preds.append(category_value)

        flag = False
        category, tokens = parse_generated_output_to_get_category(output_category)
        print("Extracted Category:", category)
        print("Extracted Tokens:", tokens)

        #output_category_lower = output_category.lower()
        category_value = categories.get(category.lower().strip(), 6)  # Return -1 if category not found
        print(category_value)
    
        total_preds.append(category_value)
        top_tokens_per_test.append(tokens)

        # Store tokens in dictionary
        #if category_value != -1:  # Valid category

        if category_value == actual_label:
            if category_value not in category_token_map:
                category_token_map[category_value] = []  # Initialize empty list if not exists
            category_token_map[category_value].extend(tokens)  # Append tokens for the category
            print("\nFinal Category-Token Map:", category_token_map)
        #exit()

    return total_preds, category_token_map, top_tokens_per_test
    #return total_preds


def preprocess_data(dataset_path, technique):
    which_dataset=technique.split("-")[1]
    where_data_comes=data_name.split("-")[0]
    dataset_category=technique.split("-")[1]
    
    df = pd.read_csv(dataset_path)
    input_data = df['full_code'] # use the 'full_code' column to run Flakify using the full code instead of pre-processed code
    #print(len(input_data))
    out_layer=""
    target_data = ""
    if which_dataset == "Flakicat":
        print("It is Flakicat")
        out_layer = 6 # if Flakicat dataset
        target_data = df['category']
    
    elif which_dataset == "IDoFT_6Cat":
        out_layer = 7 # if Flakicat dataset
        target_data = df['category']
    
    elif dataset_category == "IDoFT_2Cat":
        out_layer=2
        target_data = df['flaky'] # For multi-class
    return input_data, target_data, out_layer, dataset_category

def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    device = torch.device("cuda")
    #device = torch.device("cpu")
    #print(torch.cuda.is_available())  # This should return True if CUDA is available

    input_data, target_data, output_layer, dataset_category= preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]

    model_name, tokenizer, auto_model = gemma7b_model_define()

    execution_time = time.time()
    print("Start time of the experiment", execution_time)
    no_splits = 5 # For FlakiCat=4, IDOFT=10
    TN = FP = FN = TP = 0
    fold_number = 0
    total_execution_time = 0
    no_split = 5
    global_category_token_map = {}
    predictions_per_fold = {}
    tokens_per_fold = {}
    #print(len(input_data))
    for fold in range(no_split):
        print('fold_number=',fold)

        if os.path.exists("Flakicat_Categorization-result/score_fold"+str(fold)+"_Class.txt"):
            os.remove("Flakicat_Categorization-result/score_fold"+str(fold)+"_Class.txt")
        fit_time=0
        bert_flag=0
        total_execution_time = 0
        feature_extraction_time=0
        #total_execution_time_for_feature_extraction = 0
        print(" NOW IN FOLD NUMBER", fold)
    
        X_train_df = pd.read_csv(data_name+'/data_splits/X_train_fold'+str(fold)+'.csv')
        Y_train_df = pd.read_csv(data_name+'/data_splits/y_train_fold'+str(fold)+'.csv')
    
        X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'deadcode_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'printStatement_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'variableDeclare_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'multiLine_comment_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'singleLine_comment_perturbation_Most_important_features.csv')
        Y_test_df = pd.read_csv(data_name+'/data_splits/y_test_fold'+str(fold)+'.csv')
    
        X_test = X_test_df['full_code']
        y_test = Y_test_df['category']
    
        X_train = X_train_df['full_code']
        y_train = Y_train_df['category']
   
        #tokenizer_instance = Tokenizer(tokenizer)
        #tokens_train = tokenizer_instance.tokenize_training_data(X_train)
        #tokens_test = tokenizer_instance.tokenize_test_data(X_test)

        #Y_train = pd.DataFrame(y_train)
        y_test = pd.DataFrame(y_test)
    
        #Y_train.columns = ['which_tests']
        y_test.columns = ['which_tests']
    
        # convert labels of train, validation and test into tensors
        #train_y = torch.tensor(Y_train['which_tests'].values)
        test_y = torch.tensor(y_test['which_tests'].values)
    
        #tensor_converter = TensorConverter()
        #train_seq, train_mask = tensor_converter.convert_train_to_tensors(tokens_train)
        #test_seq, test_mask = tensor_converter.convert_test_to_tensors(tokens_test)

        # create data_loaders for train and validation dataset
        batch_size = 1

        #data_loader_factory = DataLoaderFactory(batch_size, seed_worker)
        #train_dataloader = data_loader_factory.create_train_loader(train_seq, train_mask, train_y)
        #print(X_test.head(5))
        #print(test_y.head(5))

        model = auto_model
        
        # push the model to GPU
        #model = model.to(device)
        print(len(X_test))
    
        with torch.no_grad():
            preds, category_token_map, top_tokens_per_test = give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold, test_y.numpy())
            print('All preds=')
            print(preds)
    
        predictions_per_fold[f"Fold_{fold}"] = preds
        tokens_per_fold[f"Fold_{fold}"] = top_tokens_per_test

        # Merge tokens from the current fold into the global category-token map
        for category, tokens in category_token_map.items():
            if category not in global_category_token_map:
                global_category_token_map[category] = []  # Initialize list if category not present
            global_category_token_map[category].extend(tokens)  # Append tokens from current fold
        cr=classification_report(test_y, preds)
        print(type(cr))
        parse_cr(cr, technique, str(fold))
    
        '''with open(where_data_comes+"-result/classification_report_"+str(no_splits)+"folds_"+str(fold), "a") as file:
            file.write("Fold="+str(fold)+"\n")
            file.write(cr)
            file.write("\n")
    
        cm = confusion_matrix(test_y, preds)
        #print(cm)
    	
        with open(where_data_comes+"-result/confusion_matrix_"+str(no_splits)+"folds_"+str(fold), "a") as file:
            file.write("Fold="+str(fold)+"\n")
            file.write(np.array2string(cm))
            file.write("\n")
    
        tn, fp, fn, tp = confusion_matrix(test_y, preds, labels=[0, 1]).ravel()
        TN = TN + tn
        FP = FP + fp
        FN = FN + fn
        TP = TP + tp'''
        print("delete model")
        del model
        torch.cuda.empty_cache()
        #exit() 
        fold = fold+1

    #**Merging & Saving is done AFTER the loop**
    df_predictions = pd.DataFrame.from_dict(predictions_per_fold, orient="index").transpose()
    df_tokens = pd.DataFrame.from_dict(tokens_per_fold, orient="index").transpose()
    
    # Rename columns
    df_predictions.columns = [f"Predictions_{col}" for col in df_predictions.columns]
    df_tokens.columns = [f"Tokens_{col}" for col in df_tokens.columns]
    
    # Merge both DataFrames
    df_combined = pd.concat([df_predictions, df_tokens], axis=1)
    
    # Save to CSV
    df_combined.to_csv(where_data_comes+"-result/gemma7b.csv", index=False)
    print("\nPredictions and tokens saved to gemma7b.csv")

    top_10_tokens_per_category = {}
    for category, tokens in global_category_token_map.items():
        token_counts = Counter(tokens).most_common(10)  # Get top-10 most frequent tokens
        top_10_tokens_per_category[category] = token_counts  # Store as (token, count) pairs

    # Convert to DataFrame for better visualization
    df_token_per_cat = pd.DataFrame.from_dict(
        {category: dict(tokens) for category, tokens in top_10_tokens_per_category.items()},
        orient="index"
    ).transpose()
    
    #df_token_per_cat = pd.DataFrame.from_dict(top_5_tokens_per_category, orient='index').transpose()
    # Display result
    # Print the result in a readable format
    print("\nTop-10 Tokens Per Category:")
    for category, tokens in top_10_tokens_per_category.items():
        #print(f"Category {category}: {tokens}")
        print(f"Category {category}:")
        for token, count in tokens:
            print(f"  - {token}: {count}")

def initialize_environment(seed_value):
    """Initializes the environment by setting the seed and configuring logging."""
    set_seed(seed_value)  # Set the seed for reproducibility
    setup_logging()  # Setup standardized logging

if __name__ == "__main__":
    dataset_path = sys.argv[1]
    model_weights_path = sys.argv[2]
    results_file = sys.argv[3]
    data_name = sys.argv[4]
    technique = sys.argv[5]
    initialize_environment(42)
    run_experiment(dataset_path, model_weights_path, results_file, data_name, technique)
