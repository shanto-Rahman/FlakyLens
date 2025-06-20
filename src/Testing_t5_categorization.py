import time
import sys
import os
import gc
import pandas as pd
import numpy as np
from pathlib import Path
import torch
import torch.nn as nn
from transformers import AdamW
from sklearn.metrics import confusion_matrix, classification_report
from sklearn.model_selection import StratifiedKFold
from sklearn.utils.class_weight import compute_class_weight
from imblearn.over_sampling import RandomOverSampler
from sklearn.model_selection import train_test_split
import scipy as sp
import pickle
import torch.nn.utils.prune as prune
#from torch.quantization import default_qconfig, float_qparams_weight_only_qconfig
from imblearn.over_sampling import SMOTE
from sklearn.feature_extraction.text import TfidfVectorizer
from early_stopping import EarlyStopping
from t5_model import T5_Arch
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, t5_small_model_define
from data_processing import sampling, Tokenizer, TensorConverter, DataLoaderFactory
import inspect

def initialize_environment(seed_value):
    """Initializes the environment by setting the seed and configuring logging."""
    set_seed(seed_value)  # Set the seed for reproducibility
    setup_logging()  # Setup standardized logging

# give test data to the model in chunks to avoid Cuda out of memory error
def give_test_data_in_chunks(x_test_nparray, tokenizer, model, batch_size, device, fold): #BERT
    #max_length = 1024
    max_length = 64
    x_test = pd.DataFrame(x_test_nparray)
    n = len(x_test) / batch_size
    preds_chunks = None
    paired_data = []
    model.eval()
    total_attributions = []
    total_tokens = []

    for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
        # Ensure x_test_chunk is a DataFrame
        if isinstance(x_test_chunk, pd.Series):
            x_test_chunk = x_test_chunk.to_frame().T

        # Convert DataFrame to list of strings
        test_data = x_test_chunk.iloc[:, 0].tolist() if len(x_test_chunk) > 1 else [x_test_chunk.iloc[0, 0]]

        tokens_test = tokenizer.batch_encode_plus(
            test_data, max_length=max_length, pad_to_max_length=True, truncation=True)
        test_seq = torch.tensor(tokens_test['input_ids']).to(device)
        test_mask = torch.tensor(tokens_test['attention_mask']).to(device)
        preds_chunk = model(test_seq, test_mask)
        preds_chunk = preds_chunk.detach().cpu().numpy()
        preds_chunks = preds_chunk if preds_chunks is None else np.append(
            preds_chunks, preds_chunk, axis=0)
        torch.cuda.empty_cache()     

        for i in range(preds_chunks.shape[0]):
            row = preds_chunks[i]
            paired_data.append(row)
        tokens = [tokenizer.convert_ids_to_tokens(id) for id in test_seq.cpu().numpy()]
        #print(tokens)
       
        for idx in range(test_seq.size(0)):
            tokens = tokenizer.convert_ids_to_tokens(test_seq[idx])
            #total_attributions.append(attributions[idx]) 
            total_tokens.append(tokens)

    print(f'Processed chunk with {len(test_data)} samples.')
 
    with open("Flakicat_Categorization-result/score_fold"+str(fold)+"_Class.txt", "a") as ClassFileScore:
        for row in paired_data:
            #print(row)
            ClassFileScore.write(str(row) + "\n")
    preds = np.argmax(preds_chunks, axis=1)
    
    #print(len(total_attributions))
    print(len(total_tokens))
    return preds, total_tokens


def preprocess_data(dataset_path, technique):
    which_dataset=technique.split("-")[1]
    where_data_comes=data_name.split("-")[0]
    dataset_category=technique.split("-")[1]
    #print(technique) 
    #print(dataset_category)
    #print(which_dataset)
    df = pd.read_csv(dataset_path)
    input_data = df['full_code'] # use the 'full_code' column to run Flakify using the full code instead of pre-processed code
    #print(len(input_data))
    out_layer=""
    target_data = ""
    if which_dataset == "Flakicat":
        print("It is Flakicat")
        out_layer = 6 # if Flakicat dataset
        target_data = df['category']
    
    elif which_dataset == "IDoFT_6Cat" or dataset_category == "IDoFT_6CatStructurePrune" or dataset_category == "IDoFT_6CatUnStructurePrune":
        out_layer = 7 # if Flakicat dataset
        target_data = df['category']
    
    elif dataset_category == "IDoFT_2Cat":
        out_layer=2
        target_data = df['flaky'] # For multi-class
    return input_data, target_data, out_layer

    #df = pd.read_csv(dataset_path)
    #input_data = df['full_code']
    #dataset_category = technique.split("-")[1]
    #target_df = pd.DataFrame()
    #if dataset_category == "Flakicat":
    #    output_layer = 6
    #    target_data = df['category']
    #elif dataset_category == "IDoFT_6Cat":
    #    output_layer = 7
    #    target_data = df['category']
    #elif dataset_category == "IDoFT_2Cat":
    #    output_layer = 2
    #    target_df['category'] = df['flaky']
    #    # = target_series
    #    target_data = target_df['category']
    #return input_data, target_data, output_layer

def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    device = torch.device("cuda")
    print(torch.cuda.is_available())  # This should return True if CUDA is available

    input_data, target_data, output_layer = preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]

    model_name, tokenizer, auto_model = t5_small_model_define()

    execution_time = time.time()
    print("Start time of the experiment", execution_time)
    no_splits = 10 # For FlakiCat=4, IDOFT=10
    skf = StratifiedKFold(n_splits=no_splits,shuffle=True)
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
   
        tokenizer_instance = Tokenizer(tokenizer)
        tokens_train = tokenizer_instance.tokenize_training_data(X_train)
        tokens_test = tokenizer_instance.tokenize_test_data(X_test)

        Y_train = pd.DataFrame(y_train)
        y_test = pd.DataFrame(y_test)
    
        Y_train.columns = ['which_tests']
        y_test.columns = ['which_tests']
    
        # convert labels of train, validation and test into tensors
        train_y = torch.tensor(Y_train['which_tests'].values)
        test_y = torch.tensor(y_test['which_tests'].values)
    
        tensor_converter = TensorConverter()
        train_seq, train_mask = tensor_converter.convert_train_to_tensors(tokens_train)
        test_seq, test_mask = tensor_converter.convert_test_to_tensors(tokens_test)

        # create data_loaders for train and validation dataset
        batch_size = 1

        data_loader_factory = DataLoaderFactory(batch_size, seed_worker)
        train_dataloader = data_loader_factory.create_train_loader(train_seq, train_mask, train_y)
    
        model = T5_Arch(auto_model, output_layer) 
        
        # push the model to GPU
        model = model.to(device)
    
        with torch.no_grad():
            preds, total_tokens= give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold)

    
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
    
        fold = fold+1

if __name__ == "__main__":
    dataset_path = sys.argv[1]
    model_weights_path = sys.argv[2]
    results_file = sys.argv[3]
    data_name = sys.argv[4]
    technique = sys.argv[5]
    initialize_environment(42)
    run_experiment(dataset_path, model_weights_path, results_file, data_name, technique)
