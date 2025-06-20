import time
import torch
from transformers import AutoTokenizer, AutoModelForCausalLM
from huggingface_hub import login
import sys
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, codellama_7b_instruct_model_define, parse_category_and_token_list
import pandas as pd
import os
import numpy as np
from sklearn.metrics import confusion_matrix, classification_report
import re
from collections import Counter

#login(token="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")
login(token="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")

timeStart = time.time()
def parse_category_and_tokens(output_text):
    print(output_text)
    """Parse the output text to extract the category and tokens."""
    lines = output_text.strip().split('\n')  # Split the output into lines

    category = ""
    tokens = []

    # Iterate over each line to find the category and tokens
    for line in lines:
        line = line.strip()  # Clean up whitespace
        if line.startswith("Category:"):
            category = line.split("Category:")[1].strip()
        elif line.startswith("Tokens:"):
            tokens_str = line.split("Tokens:")[1].strip()
            # Safely evaluate the tokens string to a list
            try:
                # Remove square brackets and split by comma, then strip extra spaces and quotes
                tokens = eval(tokens_str)
            except SyntaxError as e:
                print("Failed to parse tokens:", e)
                tokens = []

    return category, tokens

def give_test_data_in_chunks(x_test_nparray, tokenizer, model, batch_size, device, fold): #BERT
    #max_length = 1024; 128
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
    category_token_map = {}  # Dictionary to store tokens per category
    count = 0
    #attribution_csvfile_name = "attributions/"+dataset_category+"_attributions_category_"+str(label)+"_fold_"+str(fold)+".csv"
    #if os.path.exists(attribution_csvfile_name):
    #    os.remove(attribution_csvfile_name) 

    categories = {
    "async-wait": 0,
    "concurrency": 1,
    "time": 2,
    "unordered-collection": 3,
    "order-dependent": 4,
    "non-flaky": 5
    }
    for index, row in x_test_df.iterrows():
        test_data = row['full_code']
        #prompt = "What is the category of the given test? Is it Async wait or Concurrency or Time or Unordered collection or Order dependent test or non-flaky? \n" 
        #input_str = prompt + test_data 
        category_list=["Async-wait", "Concurrency", "Time", "Unordered-collection", "Order-dependent", "non-flaky"]
        #template=f"""You will be given a category list and a test. Your task is to identify the category of the given test. Remember you must output ONLY one category at a time for a test. And your category name MUST be within the category list.

        #Categories:
        #{category_list}

        #Test:
        #{test_data}

        #The output must be only one of the category names
        #CATEGORY:<FILL_ME>"""
        
        #template = f"""
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

        template = f"""
        Classify the given test into one of these categories: Async wait, Concurrency, Time, Unordered collection, Order dependent test, or Not Flaky.

        Test:
        {test_data}

        Based on the description, identify the category and list exactly five significant tokens from the test that influenced your decision. Follow the format below:

        Category: <Your Category Here>
        Tokens: ["token1", "token2", "token3", "token4", "token5"]

        Ensure the tokens are single words or symbols, without spaces or punctuation like dots.
        """
        inputs = tokenizer(template, return_tensors="pt")["input_ids"].to(device)
        #attention_mask = inputs["attention_mask"]
        #generated_ids = model.generate(inputs.input_ids, attention_mask = attention_mask,   pad_token_id=tokenizer.eos_token_id, max_new_tokens=10)
        generated_ids = model.generate(inputs, pad_token_id=tokenizer.eos_token_id, max_new_tokens=250)

        #output = tokenizer.batch_decode(generated_ids, skip_special_tokens=True, clean_up_tokenization_spaces=False)[0]
        output = tokenizer.batch_decode(generated_ids[:, inputs.shape[1]:], skip_special_tokens = True)
        print(output)
        #exit()
        #output_categories = output.split("\n")
        #print(output_categories)

        category, tokens = parse_category_and_tokens(output[0])
        #output_category = output_categories[0]
        print('Category_name=',category)
        print('token=', tokens)

        category_value = categories.get(category.lower().strip(), 6)  # Return -1 if category not found
        print(category_value)
    
        total_preds.append(category_value)
    
        # Store tokens in dictionary
        #if category_value != -1:  # Valid category
        if category_value not in category_token_map:
            category_token_map[category_value] = []  # Initialize empty list if not exists
        category_token_map[category_value].extend(tokens)  # Append tokens for the category
        print("\nFinal Category-Token Map:", category_token_map)

    return total_preds, category_token_map


        #flag = False
        #output_category_lower = output_category.lower()
    
        ## Check if the output matches any category
        #for category, value in categories.items():
        #    if output_category_lower == category:
        #        #print(category,"=", str(value))
        #        total_preds.append(value)
        #        flag = True

        #if not flag:
        #    total_preds.append(6)

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
    print(torch.cuda.is_available())  # This should return True if CUDA is available

    input_data, target_data, output_layer, dataset_category= preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]

    model_name, tokenizer, auto_model = codellama_7b_instruct_model_define()

    execution_time = time.time()
    print("Start time of the experiment", execution_time)
    no_splits = 10 # For FlakiCat=4, IDOFT=10
    TN = FP = FN = TP = 0
    fold_number = 0
    total_execution_time = 0
    no_split = 5
    global_category_token_map = {}
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
    
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'.csv')

        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'deadcode_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'printStatement_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'variableDeclare_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'multiLine_comment_perturbation_Most_important_features.csv')
        X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'singleLine_comment_perturbation_Most_important_features.csv')
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
        print(X_test.head(5))
        #print(test_y.head(5))

        model = auto_model
        
        # push the model to GPU
        #model = model.to(device)
    
        with torch.no_grad():
            preds, category_token_map = give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold)

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
    
        fold = fold+1

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
