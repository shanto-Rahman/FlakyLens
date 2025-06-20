import time
import sys
import gc
import pandas as pd
import numpy as np
from pathlib import Path
import torch
import torch.nn as nn
from torch.utils.data import TensorDataset, DataLoader, RandomSampler, SequentialSampler
from transformers import AdamW, AutoTokenizer, AutoModel, AutoConfig
from sklearn.metrics import confusion_matrix, classification_report
from sklearn.model_selection import StratifiedKFold
from sklearn.utils.class_weight import compute_class_weight
from imblearn.over_sampling import RandomOverSampler
from sklearn.model_selection import train_test_split
import seaborn as sns
import matplotlib.pyplot as plt
from torch.cuda.amp import autocast, GradScaler
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
import scipy as sp
import shap
import pickle
from early_stopping import EarlyStopping
from codebert_model import BERT_Arch
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, model_define
from data_processing import sampling, Tokenizer, TensorConverter, DataLoaderFactory

def custom_masked_bar_plot(class_index,mask_type,viz_type):
    #determine type of operation on the explanation object
    if viz_type=='mean':
        compute_shap=copy.copy(shap_values_multiclass.mean(0))
    if viz_type=='sum':
        compute_shap=copy.copy(shap_values_multiclass.sum(0))
    if viz_type=='abs_mean':
        compute_shap=copy.copy(shap_values_multiclass.abs.sum(0))
    if viz_type=='abs_sum':
        compute_shap=copy.copy(shap_values_multiclass.abs.sum(0))
    #create a mask to visualize either positively or negatively contributing features
    if mask_type=='pos':
        mask=compute_shap.values[:,class_index]>=0
    else:
        mask=compute_shap.values[:,class_index]<=0
    #slice values related to a given class
    compute_shap.values=compute_shap.values[:,class_index][mask]
    compute_shap.feature_names=list(np.array(compute_shap.feature_names)[mask])

def f(x_test, tokenizer, model, device):
    max_length = 1024
    n = len(x_test) / 50 
    preds_chunks = None
    #for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
    tokens_test = tokenizer.batch_encode_plus(
        x_test.tolist(), max_length=max_length, pad_to_max_length=True, truncation=True)
    test_seq = torch.tensor(tokens_test['input_ids'])
    test_mask = torch.tensor(tokens_test['attention_mask'])
    preds_chunk = model(test_seq.to(device), test_mask.to(device))
    preds_chunk = preds_chunk.detach().cpu().numpy()
    preds_chunks = preds_chunk if preds_chunks is None else np.append(
        preds_chunks, preds_chunk, axis=0)

    scores = (np.exp(preds_chunks).T / np.exp(preds_chunks).sum(-1)).T
    val = sp.special.logit(scores) 
    return val

# Define a closure that includes tokenizer
def get_f_with_tokenizer(tokenizer, model, device):
    def f_with_tokenizer(x_test):
        return f(x_test, tokenizer, model, device)
    return f_with_tokenizer

# give test data to the model in chunks to avoid Cuda out of memory error
def give_test_data_in_chunks(x_test):
    n = len(x_test) / 50 
    preds_chunks = None
    for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
        tokens_test = tokenizer.batch_encode_plus(
            x_test_chunk.tolist(), max_length=1024, pad_to_max_length=True, truncation=True)
        test_seq = torch.tensor(tokens_test['input_ids'])
        test_mask = torch.tensor(tokens_test['attention_mask'])
        preds_chunk = model(test_seq.to(device), test_mask.to(device))
        preds_chunk = preds_chunk.detach().cpu().numpy()
        preds_chunks = preds_chunk if preds_chunks is None else np.append(
            preds_chunks, preds_chunk, axis=0)
        preds = np.argmax(preds_chunks, axis=1)

    return preds

def preprocess_data(dataset_path, technique):
    df = pd.read_csv(dataset_path)
    input_data = df['full_code']
    dataset_category = technique.split("-")[1]

    if dataset_category == "Flakicat":
        output_layer = 5
        target_data = df['category']
    elif dataset_category == "IDoFT_6Cat" or dataset_category == "IDoFT_6CatStructurePrune" or dataset_category == "IDoFT_6CatUnStructurePrune":
        output_layer = 7
        target_data = df['category']
    elif dataset_category == "IDoFT_2Cat":
        output_layer = 2
        target_data = df['flaky']
    return input_data, target_data, output_layer

def get_features_for_a_category(cohorts, category_name, fold, data_name):
    cohort_labels = list(cohorts.keys())
    cohort_exps = list(cohorts.values())
    features = cohort_exps[0].data
    feature_names = cohort_exps[0].feature_names
    values = np.array([cohort_exps[i].values for i in range(len(cohort_exps))]).T
    
    true_pair_df = pd.DataFrame({'Data':feature_names, 'Values': values[:,0]})
    csv_filename ='shap_features/fold_' + str(fold)+ '_' + data_name +'_'+str(category_name)+'_shap_values.csv'  # Added underscore
    true_pair_df.to_csv(csv_filename, index=False)

def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    device = torch.device("cuda")
    print(torch.cuda.is_available())  # This should return True if CUDA is available

    input_data, target_data, output_layer = preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]
    dataset_category = technique.split("-")[1]
    model_name, tokenizer, auto_model = model_define()

    execution_time = time.time()
    #print("Start time of the experiment", execution_time)
    #skf = StratifiedKFold(n_splits=5,shuffle=True)
    TN = FP = FN = TP = 0
    n_folds = 10
    
    for fold in range(n_folds): #fol        

        '''X_test=np.load(data_name+'/data_splits/X_test_fold'+str(i)+'.npy' ,allow_pickle=True)
        y_test=np.load(data_name+'/data_splits/y_test_fold'+str(i)+'.npy' ,allow_pickle=True)
        X_test=np.asarray(X_test)'''

        X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'.csv')
        Y_test_df = pd.read_csv(data_name+'/data_splits/y_test_fold'+str(fold)+'.csv')

        X_test = X_test_df['full_code']
        y_test = Y_test_df['category']

        model = BERT_Arch(auto_model, output_layer)
        # push the model to GPU
        model = model.to(device)
        gc.collect()
        torch.cuda.empty_cache()
        # set initial loss to infinite
    
        # load weights of best model
        #print((model_weights_path+str(fold)+'.pt'))
        model.load_state_dict(torch.load(model_weights_path+str(fold)+'.pt'))
        #model = pickle.load(open('filename_RF0', 'rb'))
        
    
        ##Explainablibility, Shap
        #id2label = {0: 'NDOD', 1: 'NOD', 2: 'OD', 3: 'ID', 4: 'NIO', 5: 'UD'}
        id2label = {0: 'async wait', 1: 'concurrency', 2: 'time', 3: 'unordered collections', 4: 'test order dependency'}
        labels = list(id2label.values())
        label2id = {}
        for j,label in enumerate(labels):
            label2id[label]=j
         
        # Create a SHAP explainer
        #explainer = shap.KernelExplainer(model.predict_proba, X_test)
        #explainer = shap.Explainer(model)
    
        # Compute SHAP values
        #shap_values_multiclass = explainer(X_test)
        f_with_tokenizer = get_f_with_tokenizer(tokenizer, model, device)

        ''' #===========Needed only for training===============
        with torch.no_grad():
            explainer = shap.Explainer(f_with_tokenizer, tokenizer, output_names=labels, output_shape=(X_test.shape[0], output_layer))
            shap_values_multiclass = explainer(X_test)
    
        with open("shap_model/shap_values_multiclass"+"_"+str(dataset_category)+"_"+str(fold)+".pkl", "wb") as fl:
            pickle.dump(shap_values_multiclass, fl)'''
    
        # Load the saved shap_values_multiclass object
        with open("shap_model/shap_values_multiclass"+"_"+str(dataset_category)+"_"+str(fold)+".pkl", "rb") as fl:
            shap_values_multiclass = pickle.load(fl)
    
        shap_values_matrix = shap_values_multiclass.values.reshape(X_test.shape[0], -1) #shap_values.reshape(shap_values.shape[0], -1)
        print(shap_values_multiclass[0])

        shap_values_asyn_wait = shap_values_multiclass.mean(0)[:, label2id['async wait']] 
        cohorts = {"": shap_values_asyn_wait}
        #print('MUSTU')
        #shap.plots.bar(shap_values)
        #plt.savefig('shap_model/shap_plot_True-Pair'+str(i)+data_name+'.png')
        #plt.close()
        get_features_for_a_category(cohorts, 'async wait', fold, data_name) 

        # Generate the summary plot
        #shap.plots.bar(shap_values_multiclass.mean(0)[:,label2id['OD']])
        #shap.summary_plot(shap_values_matrix, X_test)
        shap.plots.bar(shap_values_multiclass.mean(0)[:,label2id['async wait']])
        plt.savefig('shap_model/shap_plot_AsyncWait'+str(fold)+'.png')
        plt.close()
    
        shap.plots.bar(shap_values_multiclass.mean(0)[:,label2id['concurrency']])
        plt.savefig('shap_model/shap_plot_Concurrency'+str(fold)+'.png')
        plt.close()
    
        shap.plots.bar(shap_values_multiclass.mean(0)[:,label2id['time']])
        plt.savefig('shap_model/shap_plot_Time'+str(fold)+'.png')
        plt.close()
    
        shap.plots.bar(shap_values_multiclass.mean(0)[:,label2id['unordered collections']])
        plt.savefig('shap_model/shap_plot_UC'+str(fold)+'.png')
        plt.close()
    
        shap.plots.bar(shap_values_multiclass.mean(0)[:,label2id['test order dependency']])
        plt.savefig('shap_model/shap_plot_TOD'+str(fold)+'.png')
        plt.close()
    
        #shap.plots.bar(shap_values_multiclass.mean(0)[:,label2id['UD']])
        #plt.savefig('shap_model/shap_plot_UD'+str(i)+'.png')
        #plt.close()
    
        print("delete model")
        del model
        torch.cuda.empty_cache()
    
    
    print("The processed is completed in : (%s) seconds. " % round((time.time() - execution_time), 5))



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
    where_data_comes=data_name.split("-")[0]
    initialize_environment(42) 
    run_experiment(dataset_path, model_weights_path, results_file, data_name, technique)
    
