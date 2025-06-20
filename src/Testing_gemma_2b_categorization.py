import time
import torch
from transformers import AutoTokenizer, AutoModelForCausalLM
from huggingface_hub import login
import sys
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, gemma2b_model_define
import pandas as pd
import os
import numpy as np
import json
from sklearn.metrics import confusion_matrix, classification_report
import re

#login(token="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")
login(token="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")

timeStart = time.time()

def identify_test_category(test_data, tokenizer, model, device):
    category_list=["Async-wait", "Concurrency", "Time", "Unordered-collection", "Order-dependent", "non-flaky"]
    template=f"""You will be given a category list and a test. Your task is to identify the category of the test. Remember you must output ONLY one category at a time for a test. And your category name MUST be within the category list.
    
    Categories:
    {category_list}

    Test:
    {test_data}

    The output should be only the category name
    CATEGORY:"""

    #template = f"""
    #Classify the given test as one of the following categories: Async wait or Concurrency or Time or Unordered collection or Order dependent test or non-flaky.

    #Test:
    #{test_data}                        
    #Give **ONLY** the category name.

    #Your outout must fill up <category_name> from the following output.

    #CATEGORY:<category_name>
    #"""


    '''messages = [
        { "role": "user", "content": template},
        ]
    input_ids = tokenizer.apply_chat_template(
        messages, 
        add_generation_prompt=True, 
        return_tensors="pt"
    ).to(model.device)
    #input_ids = tokenizer(template, return_tensors="pt").to(device)
    outputs = model.generate(input_ids=input_ids, 
        max_new_tokens=250,
        eos_token_id=tokenizer.eos_token_id,
        do_sample=False,
        temperature=0.8,
        top_p=1,
    )'''
    input_ids = tokenizer(template, return_tensors="pt").to(device)
    outputs = model.generate(**input_ids, max_new_tokens=250
     )

    output = tokenizer.decode(outputs[0], skip_special_tokens=True)
    output = output.split("CATEGORY:", 1)[1]

    print(output)
    #print(output)
    output_lines = output.split('\n')
    category_name = ""
    #category_name = next((item.strip() for item in output_lines if item.strip()), None)
    for item in output_lines: 
        if item.strip():
            first_non_empty = item.strip()
            category_name = first_non_empty
            break
    #exit()
    output_category_lower = category_name.lower()
    return output_category_lower

def give_test_data_in_chunks(x_test_nparray, tokenizer, model, batch_size, device, fold): #BERT
    print('FROM GEMMA')
    max_length = 512
    x_test_df = pd.DataFrame(x_test_nparray)
    n = 1 #len(x_test) / batch_size
    preds_chunks = None
    paired_data = []
    model.eval()
    total_tokens = []
    total_preds = []
    count = 0

    for index, row in x_test_df.iterrows():
        test_data = row['full_code']
        flag = False
        #while True:
        output_category_lower = identify_test_category(test_data, tokenizer, model, device)
        print(output_category_lower) 
        categories = {
        "async-wait": 0,
        "concurrency": 1,
        "time": 2,
        "unordered-collection": 3,
        "order-dependent": 4,
        "non-flaky": 5
        }
        # Check if the output matches any category
        for category, value in categories.items():
            if output_category_lower == category:
                print(value)
                #print(type(value))
                total_preds.append(value)
                flag=True
            #else:
            #    print('category name not from category list')
                #total_preds.append(value)
        if not flag:
            total_preds.append(6)
        #    break
    return total_preds


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

'''def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    device = torch.device("cuda")
    #device = torch.device("cpu")
    #print(torch.cuda.is_available())  # This should return True if CUDA is available

    input_data, target_data, output_layer, dataset_category= preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]

    model_name, tokenizer, auto_model = gemma2b_model_define()

    execution_time = time.time()
    print("Start time of the experiment", execution_time)
    no_splits = 10 # For FlakiCat=4, IDOFT=10
    TN = FP = FN = TP = 0
    fold_number = 0
    total_execution_time = 0
    no_split = 10
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
    
        with torch.no_grad():
            preds = give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold)
            print('All preds=')
            print(preds)
    
        cr=classification_report(test_y, preds)
        print(type(cr))
        parse_cr(cr, technique, str(fold))
    
        with open(where_data_comes+"-result/classification_report_"+str(no_splits)+"folds_"+str(fold), "a") as file:
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
        TP = TP + tp
        print("delete model")
        del model
        torch.cuda.empty_cache()
    
        fold = fold+1'''

def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    device = torch.device("cuda")
    #device = torch.device("cpu")
    #print(torch.cuda.is_available())  # This should return True if CUDA is available

    input_data, target_data, output_layer, dataset_category= preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]

    model_name, tokenizer, auto_model = gemma2b_model_define()

    execution_time = time.time()
    print("Start time of the experiment", execution_time)
    #no_splits = 10 # For FlakiCat=4, IDOFT=10
    TN = FP = FN = TP = 0
    fold_number = 0
    total_execution_time = 0
    no_split = 5
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
    
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'deadcode_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'printStatement_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'variableDeclare_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'multiLine_comment_perturbation_Most_important_features.csv')
        #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'singleLine_comment_perturbation_Most_important_features.csv')
        X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'.csv')
        Y_test_df = pd.read_csv(data_name+'/data_splits/y_test_fold'+str(fold)+'.csv')
        #print(len(X_test_df))
        #print(len(Y_test_df))
        #exit()
    
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
    
        with torch.no_grad():
            preds = give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold)
            print('All preds=')
            print(preds)
    
        cr=classification_report(test_y, preds)
        print(type(cr))
        parse_cr(cr, technique, str(fold))
    
        with open(where_data_comes+"-result/classification_report_"+str(no_split)+"folds_"+str(fold), "a") as file:
            file.write("Fold="+str(fold)+"\n")
            file.write(cr)
            file.write("\n")
    
        cm = confusion_matrix(test_y, preds)
        #print(cm)
    	
        with open(where_data_comes+"-result/confusion_matrix_"+str(no_split)+"folds_"+str(fold), "a") as file:
            file.write("Fold="+str(fold)+"\n")
            file.write(np.array2string(cm))
            file.write("\n")
    
        tn, fp, fn, tp = confusion_matrix(test_y, preds, labels=[0, 1]).ravel()
        TN = TN + tn
        FP = FP + fp
        FN = FN + fn
        TP = TP + tp
        print("delete model")
        del model
        torch.cuda.empty_cache()
    
        fold = fold+1

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
