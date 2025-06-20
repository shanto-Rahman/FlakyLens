import os
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
from sklearn.ensemble import RandomForestClassifier, GradientBoostingClassifier
from sklearn import svm, tree
import time
from sklearn.tree import DecisionTreeClassifier
from sklearn.ensemble import AdaBoostClassifier
from sklearn.naive_bayes import GaussianNB
from sklearn.neural_network import MLPClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.linear_model import LogisticRegression
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
import scipy as sp
import pickle
import sklearn.metrics as metrics
import torch.nn.utils.prune as prune
import torch.quantization
import torch.quantization as quantization
from codebert_model import BERT_Arch
from cig import CustomIntegratedGradients
from torch.quantization import fuse_modules
from codebert_model import BERT_Arch
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, codebert_model_define
from data_processing import sampling, Tokenizer, TensorConverter, DataLoaderFactory
#from renaming_variable import rename_variables_in_code
import torch.backends.cudnn as cudnn
from perturbation import printStatement_insertion, deadcode_insertion, variableRenaming_insertion, multi_comment_insertion, single_comment_insertion
#from captum.attr import IntegratedGradients, LayerConductance, LayerIntegratedGradients
import matplotlib.pyplot as plt
from interpret import show
from interpret.blackbox import ShapKernel
from functools import partial
#from shap_explainer import flakicat_explain 
from captum.attr import visualization
from selenium import webdriver
import time
import io
from contextlib import redirect_stdout
from IPython.core.display import display, HTML
from captum.attr import visualization as viz
from bs4 import BeautifulSoup
import subprocess
import torch.nn.functional as F
import csv

vis_data_records_ig = []

def combination_of_perturbation(X_test, y_test, X_test_df, k=5):
    if k == 2:
        #X_test_df['full_code']  = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement")
        #X_test_df.to_csv('tmp', index = False)
        #exit()
        #X_test_df['full_code']  = combine_perturbation_technique(X_test, y_test, "deadcode", "variableRenaming")
        #X_test_df['full_code']  = combine_perturbation_technique(X_test, y_test, "deadcode", "multi_comment")
        #X_test_df['full_code']  = combine_perturbation_technique(X_test, y_test, "deadcode", "single_comment")

        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "printStatement", "variableRenaming")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "printStatement", "multi_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "printStatement", "single_comment") 
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "variableRenaming", "multi_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "variableRenaming", "single_comment")
        X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "multi_comment", "single_comment")
    
    if k == 3:
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement", "variableRenaming")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement", "multi_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement", "single_comment")

        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "variableRenaming", "multi_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "variableRenaming", "single_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "multi_comment", "single_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "printStatement", "variableRenaming", "multi_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "printStatement", "variableRenaming", "single_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "printStatement", "multi_comment", "single_comment")
        X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "variableRenaming", "multi_comment", "single_comment")

    if k == 4:
        X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement", "variableRenaming", "multi_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement", "variableRenaming", "single_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement", "multi_comment", "single_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "variableRenaming", "multi_comment", "single_comment")
        #X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "printStatement", "variableRenaming", "multi_comment", "single_comment")

    if k == 5:
        X_test_df['full_code'] = combine_perturbation_technique(X_test, y_test, "deadcode", "printStatement", "variableRenaming", "multi_comment", "single_comment")

    return X_test_df


#def prepare_data_for_shap(test_seq, test_mask):
#    return [np.hstack((seq.cpu().numpy(), mask.cpu().numpy())) for seq, mask in zip(test_seq, test_mask)]
#
#def visualize_importances(feature_names_list_of_list, importances_list_of_list, title="Average Feature Importances", plot=True, axis_title="Features"):
#    print(title)
#	
#    for i, (feature_names, importances) in enumerate(zip(feature_names_list_of_list, importances_list_of_list)):	
#        for i in range(len(feature_names)): #one test's feature list
#            if importances[i] > 0.000:
#                print(feature_names[i], ": ", '%.3f'%(importances[i]))
#        x_pos = (np.arange(len(feature_names)))
#        if plot:
#            if isinstance(importances, torch.Tensor):
#                importances = importances.cpu().numpy()
#
#            plt.figure(figsize=(12,6))
#            plt.bar(x_pos, importances, align='center')
#            plt.xticks(x_pos, feature_names, wrap=True)
#            plt.xlabel(axis_title)
#            plt.title(title)
#            plt.savefig(f"attributions/attribution_{i+1}.png", bbox_inches='tight')
#            plt.close()

def add_attributions_to_visualizer(attributions, tokens, pred_class, pred_logit, label, vis_data_records, test_y, approximation_error):
    if not isinstance(attributions, torch.Tensor):
        attributions = torch.tensor(attributions)

    attributions = attributions / torch.norm(attributions)
    attributions = attributions.detach().cpu().numpy()
    pred_list = pred_class.tolist() if isinstance(pred_class, np.ndarray) else pred_class
    #print(pred_list)
    #print('original=',test_y)
    flat_tokens = tokens[0]
    #convergence_score = attributions.sum()
    assert len(flat_tokens[:len(attributions)]) == len(attributions), "Tokens and attributions length mismatch"
    # storing couple samples in an array for visualization purposes
    vis_data_records.append(visualization.VisualizationDataRecord(
                            attributions,
                            pred_list[0],
                            pred_logit,
                            label,
                            "label",
                            attributions.sum(),       
                            flat_tokens[:len(attributions)],
                            #convergence_score
                            approximation_error
                            ))    

#def plot_text_attributions(total_tokens, total_attributions, save_path=None):
#    max_width = 2000
#    for i, (token_list, attribution_list) in enumerate(zip(total_tokens, total_attributions)):
#		# Adjust width dynamically based on the number of tokens, ensuring each token has adequate space
#        fig_width = min(max_width, max(20, len(token_list) * 0.5))
#        fig_height = 4  # Increase height for better visibility
#        plt.figure(figsize=(10, 4), dpi=100)
#
#        if isinstance(attribution_list, torch.Tensor):
#            attribution_list = attribution_list.cpu().detach().numpy()
#
#        max_val = np.max(attribution_list)
#        normalized_attributions = attribution_list / max_val if max_val > 0 else attribution_list
#        colors = plt.cm.viridis(normalized_attributions)
#        font_size = min(16, 800 / len(token_list))
#
#        for j, (token, color) in enumerate(zip(token_list, colors)):
#            plt.text(j, 0, token, color=color, ha='center', va='center', fontsize=font_size)
#
#        plt.xticks([])
#        plt.yticks([])
#        plt.title(f"Attribution Plot for Instance {i+1}", fontsize=font_size)
#        plt.savefig(f"attributions/attribution_{i+1}.png", bbox_inches='tight')
#        plt.close()  # Close the figure to free memory


def save_attributions(tokens, attributions, predictions, filepath, ground_truth, pred_logit, test_confidence_score):
    flat_tokens = [item for sublist in tokens for item in sublist] if isinstance(tokens[0], list) else tokens
    flat_attributions = attributions.tolist() if isinstance(attributions, torch.Tensor) else attributions 
    #print(type(pred_logit))
   
    #print(type(flat_attributions))
    #print(flat_attributions)
    pred_logit_converted = pred_logit.tolist() if isinstance(pred_logit, torch.Tensor) else pred_logit
    confidence_score_converted = test_confidence_score.item() if isinstance(test_confidence_score, torch.Tensor) else confidence_score

    data = [
        {'Token': token, 'Attribution': attr, 'Predicted_class': predictions, 'True_class':ground_truth, 'Test_Pred_logit':pred_logit_converted[0], 'Test_confidence_score':confidence_score_converted} 
        for token, attr in zip(flat_tokens, flat_attributions)
        if token != '<pad>'
    ]
    df = pd.DataFrame(data)
    df.to_csv(filepath, index=False, mode='a')

def calculate_attributions(input_ids, attention_mask, model, integrated_gradients, label):
    #print(f"Before attribution calculation: input_ids shape {input_ids.shape}, attention_mask shape {attention_mask.shape}") 
    embeddings = model.get_embeddings(input_ids) 
    embeddings = embeddings.clone().detach().float().requires_grad_(True)
    attention_mask = attention_mask.clone().detach().float()
    try:
        attributions= integrated_gradients.attribute(inputs=(embeddings, attention_mask), target=label, return_convergence_delta=True)
        approximation_error = None
        print("Attributions calculated.")
    except RuntimeError as e:
        print(f"from calculate_attribution Attribution calculation failed: {e}")
        attributions = None
    return attributions, approximation_error


def give_test_data_in_chunks(x_test_nparray, tokenizer, model, batch_size, device, fold, label, Y_test, dataset_category, attributions_dir, calculate_attribution=False): #BERT
    max_length = 512 #; 128
    #max_length = 512
    x_test = pd.DataFrame(x_test_nparray)
    n = 1
    preds_chunks = None
    paired_data = []
    model.eval()
    total_attributions = []
    total_tokens = []
    total_preds = []
    vis_data_records_ig = []
    count = 0
    confidence_scores = []
    #wrapped_model = CustomModelWrapper(model)
    cig = CustomIntegratedGradients(model)
    attribution_csvfile_name = attributions_dir+dataset_category+"_attributions_category_"+str(label)+"_fold_"+str(fold)+".csv"
    if os.path.exists(attribution_csvfile_name):
        os.remove(attribution_csvfile_name) 
    for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
        count +=1
        # Ensure x_test_chunk is a DataFrame
        if isinstance(x_test_chunk, pd.Series):
            x_test_chunk = x_test_chunk.to_frame().T
        # Convert DataFrame to list of strings
        test_data = x_test_chunk.iloc[:, 0].tolist() if len(x_test_chunk) > 1 else [x_test_chunk.iloc[0, 0]]
        test_y = Y_test['which_tests'].iloc[g]
        tokens_test = tokenizer.batch_encode_plus(test_data, max_length=max_length, pad_to_max_length=True, truncation=True)
        test_seq = torch.tensor(tokens_test['input_ids']).to(device).long()
        test_mask = torch.tensor(tokens_test['attention_mask']).to(device).long()
        print('test_x=', test_data)
        print('test_y=', test_y)

        preds_chunk = model(test_seq, test_mask)
        #print(f'preds_chunk dtype: {preds_chunk.dtype}, shape: {preds_chunk.shape}')  # Debugging line
        preds_chunk = preds_chunk.detach().cpu().numpy()
        logit_tensor = torch.tensor(preds_chunk, dtype=torch.float)  # Convert to tensor
        # Apply softmax using PyTorch
        #print('preds_chunk_tensor=',logit_tensor)
        probabilities = F.softmax(logit_tensor, dim=1)
        #print("probabilities=",probabilities)
        confidence_score = torch.max(probabilities) 
        #print('confidence_score=',confidence_score)
        #exit()
        confidence_scores.append(confidence_score.item()) 

        ##print('confidence_score=',confidence_scores)
        print('preds_chunk=', preds_chunk)
        #exit()
        pred_class = np.argmax(preds_chunk, axis=1)
        pred_logit = preds_chunk[0, pred_class]
        total_preds.append(pred_class)
        #print(str(confidence_score)," " ,str(pred_class))
        #exit()
        if calculate_attribution:
            try:

                #print(f'Before attribution calculation: test_seq shape {test_seq.shape}, test_mask shape {test_mask.shape}')  # Debugging line
                attributions, approximation_error = calculate_attributions(test_seq, test_mask, model, cig, label)

                #print(len(attributions))
                if attributions is not None:
                    #print('Attribution calculation successful')
                    attributions_tensor = attributions[0]
                    #print(attributions_tensor.shape)
                    attributions_sum = attributions_tensor.sum(dim=2).squeeze(0).detach().cpu().numpy()
                    #print(attributions_sum)
                    total_attributions.append(attributions_sum)
                    tokens = [tokenizer.convert_ids_to_tokens(id) for id in test_seq.cpu().numpy()]
                    total_tokens.append(tokens)
                    # Print each token with its corresponding attribution score
                    print("Token | Attribution Score")
                    print("-------------------------")
                    #for token, score in zip(tokens, attributions_sum):
                    #    print(f"{token:10} | {score:.4f}")
                    #print(attributions_sum)
                    #print(tokenizer.convert_ids_to_tokens(test_seq.squeeze(0).tolist()))
                    #exit()
            except RuntimeError as e:
                print(f"from give_test_data_in_chunks Attribution calculation failed: {e}")
                print(f"Input IDs shape: {test_seq.shape}, Attention mask shape: {test_mask.shape}")

            #print(attributions_sum.shape)
            save_attributions(tokens, attributions_sum, pred_class, attribution_csvfile_name, test_y, logit_tensor, confidence_score)
            #exit()
         
            add_attributions_to_visualizer(attributions_sum, tokens, pred_class, pred_logit, label, vis_data_records_ig, test_y, approximation_error)
    #print('I should get attribution score and tokens')
    #exit()
    modified_html_content = ""
    if calculate_attribution:
        html_obj = viz.visualize_text(vis_data_records_ig)
        html_content = html_obj.data 
        html_content = html_content.replace('True Label', 'Target Label')

        soup = BeautifulSoup(html_content, 'html.parser')
        rows = soup.find_all('tr')
        header_row = rows[0]
        new_col_header = soup.new_tag('th')
        new_col_header.string = 'Ground Truth'
        #header_row.append(new_col_header)
        header_row.insert(1, new_col_header)

        data_rows_start = 1
        for idx, (row, test_value) in enumerate(zip(rows[data_rows_start::2], Y_test['which_tests']), start=data_rows_start):
            new_col_data = soup.new_tag('td')
            new_col_data.string = str(test_value)
            #print('********Ground-truth=', str(test_value))
            row.insert(1, new_col_data)

        modified_html_content = str(soup)
    return total_preds, modified_html_content, attribution_csvfile_name, confidence_scores

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
        out_layer = 6 # if Flakicat dataset but with non-flaky category it will be 6
        target_data = df['category']
    
    elif which_dataset == "IDoFT_6Cat":
        out_layer = 7 # if Flakicat dataset
        target_data = df['category']
    
    elif dataset_category == "IDoFT_2Cat":
        out_layer=2
        target_data = df['flaky'] # For multi-class
    return input_data, target_data, out_layer, dataset_category

# Mapping from perturbation technique names to actual function objects
function_map = {
    'deadcode_insertion': deadcode_insertion,
    'printStatement_insertion': printStatement_insertion,
    'variableRenaming_insertion': variableRenaming_insertion,
    'multi_comment_insertion': multi_comment_insertion, 
    'single_comment_insertion': single_comment_insertion
    # Add other mappings here
}

def combine_perturbation_technique(X_test, y_test, perturb1, perturb2, perturb3="", perturb4="", perturb5=""):
    perturbation_array = [perturb1, perturb2, perturb3, perturb4, perturb5] 
    
    # Filter out empty values and calculate the length
    non_empty_perturbations = [p for p in perturbation_array if p]
    num_perturbation = len(non_empty_perturbations) # non-empty pertubation
    
    print(f"Length of non-empty perturbations: {num_perturbation}")

    for perturbation_tech in perturbation_array:
        if perturbation_tech:
            meth_name = perturbation_tech+"_insertion"
            if meth_name in function_map:
            #print(meth_name)
                func = function_map[meth_name]
                X_test = func(X_test, y_test, num_perturbation="multi_perturb_"+str(num_perturbation))
            else:
               print('No function mapped.......')
            #print('***I AM CALLING PERTURBATION****')
     
    return X_test

def converting_df_to_series(X_train_df, Y_train_df, X_valid_df, Y_valid_df, X_test_df, Y_test_df):
    X_test = X_test_df['full_code']
    y_test = Y_test_df['category']
    #print(y_test.values)
    X_train = X_train_df['full_code']
    y_train = Y_train_df['category']
    
    X_valid = X_valid_df['full_code']
    y_valid = Y_valid_df['category']
    return X_test, y_test, X_train, y_train, X_valid, y_valid

def read_data(data_name, fold):
    
    X_train_df = pd.read_csv(data_name+'/data_splits/X_train_fold'+str(fold)+'.csv')
    Y_train_df = pd.read_csv(data_name+'/data_splits/y_train_fold'+str(fold)+'.csv') 
    X_valid_df = pd.read_csv(data_name+'/data_splits/X_valid_fold'+str(fold)+'.csv')
    Y_valid_df = pd.read_csv(data_name+'/data_splits/y_valid_fold'+str(fold)+'.csv')

    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'deadcode_perturbation.csv')
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'printStatement_perturbation.csv')
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'variableDeclare_perturbation.csv')
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'multiLine_comment_perturbation.csv')
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'singleLine_comment_perturbation.csv')
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'.csv') # Without any perturbation in the test data
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'deadcode_perturbation_Most_important_features.csv')
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'printStatement_perturbation_Most_important_features.csv')
    #print("file_name=",data_name+'/data_splits/X_test_fold'+str(fold)+'variableDeclare_perturbation_Most_important_features.csv')
    X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'variableDeclare_perturbation_Most_important_features.csv')

    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'multiLine_comment_perturbation_Most_important_features.csv')
    #X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'singleLine_comment_perturbation_Most_important_features.csv')
    Y_test_df = pd.read_csv(data_name+'/data_splits/y_test_fold'+str(fold)+'.csv')
    return X_train_df, Y_train_df, X_valid_df, Y_valid_df, X_test_df, Y_test_df

def boosting_noisy_data_for_train(X_train, y_train, fold): 
    # Assuming X_train and y_train are pandas Series and converting them to numpy arrays
    X_train = np.array(X_train)
    y_train = np.array(y_train)
    
    # Shuffle the data indices
    indices = np.random.permutation(len(X_train))
    
    # Determine the size of each split (20% of the data)
    split_size = len(X_train) // 5
    
    # List of perturbation functions
    perturbation_functions = [
        "deadcode_perturbation",
        "printStatement_perturbation",
        "variableDeclare_perturbation",
        "multiLine_comment_perturbation",
        "singleLine_comment_perturbation"
    ]

    # Mapping of perturbation names to actual functions
    perturbation_func_map = {
        "deadcode_perturbation": deadcode_insertion,
        "printStatement_perturbation": printStatement_insertion,
        "variableDeclare_perturbation": variableRenaming_insertion,
        "multiLine_comment_perturbation": multi_comment_insertion,
        "singleLine_comment_perturbation": single_comment_insertion
    }

    # Create 5 non-overlapping splits
    X_train_splits = []
    y_train_splits = []
    # Append the original X_train and y_train data before perturbation
    #X_train_splits.append(pd.DataFrame(X_train, columns=['full_code']))  # Add original X_train
    #y_train_splits.append(pd.DataFrame(y_train, columns=['category']))  # Add original y_train             

    for i in range(5):
        start_idx = i * split_size
        end_idx = (i + 1) * split_size if i != 4 else len(X_train)  # Include the remaining data in the last split

        split_indices = indices[start_idx:end_idx]
        X_split = X_train[split_indices]
        y_split = y_train[split_indices]

        # Convert numpy arrays to pandas DataFrame before calling perturbation
        X_split_df = pd.DataFrame(X_split, columns=['full_code'])  # Assuming 'full_code' is the column name
        y_split_df = pd.DataFrame(y_split, columns=['category'])  # Assuming 'category' is the column name
        
        # Convert 'full_code' and 'category' to Series to match deadcode_insertion expectations
        X_split_series = X_split_df['full_code']  # Convert to Series
        y_split_series = y_split_df['category']   # Convert to Series

        #print("Before Perturbation:")
        #print(X_split_series.head())
        
        # Select perturbation function based on the split
        perturbation_name = perturbation_functions[i]
        perturbation_func = perturbation_func_map[perturbation_name]
        print(f"Applying {perturbation_name} to split {i+1}")

        # Apply the perturbation
        X_split_modified = perturbation_func(X_split_series, y_split_series)  # Call the function with Series

        #print("After Perturbation:")
        #print(X_split_modified.head())
        #exit()
        # Store modified and original splits
        X_train_splits.append(pd.DataFrame(X_split_modified, columns=['full_code']))
        y_train_splits.append(pd.DataFrame(y_split, columns=['category']))

        #print(y_split)
    
    # Merge back into the original data
    X_train_augmented = pd.concat(X_train_splits, axis=0).reset_index(drop=True)
    y_train_augmented = pd.concat(y_train_splits, axis=0).reset_index(drop=True)
    print(len(X_train_augmented), len(y_train_augmented ))
    # Save the augmented X_train to a CSV file
    #X_output_csv_file = "Flakicat_Categorization-Data/data_splits/X_train_fold"+str(fold)+"_only_noisy_data.csv"
    #y_output_csv_file = "Flakicat_Categorization-Data/data_splits/y_train_fold"+str(fold)+"_only_noisy_data.csv"

    X_output_csv_file = "Flakicat_Categorization-Data/data_splits/X_valid_fold"+str(fold)+"_only_noisy_data.csv"
    y_output_csv_file = "Flakicat_Categorization-Data/data_splits/y_valid_fold"+str(fold)+"_only_noisy_data.csv"
    X_train_augmented.to_csv(X_output_csv_file, index=False)
    y_train_augmented.to_csv(y_output_csv_file, index=False)


def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    device = torch.device("cuda")
    #device = torch.device("cpu")
    ml_technique=technique.split("-")[0]
    input_data, target_data, output_layer, dataset_category = preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0] 
    model_name, tokenizer, auto_model = codebert_model_define()

    execution_time = time.time()
    #print("Start time of the experiment", execution_time)
    no_split = 5 # For Flakicat (10 folds)
    skf = StratifiedKFold(n_splits=no_split,shuffle=True)
    TN = FP = FN = TP = 0
    
    prediction_time_codebert = 0
    categories = 1 # 5 if attribution
    if os.path.exists("../flaky-test-categorization/without_adversarial_per_Category_Evaluation_BERT-Flakicat.txt"):
        os.remove("../flaky-test-categorization/without_adversarial_per_Category_Evaluation_BERT-Flakicat.txt")
    #calculate_attribution = True
    calculate_attribution = False
    if calculate_attribution:
        categories = 6
    for label in range(categories):
        for fold in range(no_split):
            print("FOLD=", fold)
            if os.path.exists("Flakicat_Categorization-result/score_fold"+str(fold)+"_Class.txt"):
                os.remove("Flakicat_Categorization-result/score_fold"+str(fold)+"_Class.txt")
            fit_time=0
            bert_flag=0
            total_execution_time = 0
            feature_extraction_time=0
            #total_execution_time_for_feature_extraction = 0
            print(" NOW IN FOLD NUMBER", fold)
       
            X_train_df, Y_train_df, X_valid_df, Y_valid_df, X_test_df, Y_test_df = read_data(data_name, fold)
        
            #X_test_df.columns = ['test_code']
            #Y_test_df.columns = ['label']
        
            X_test, y_test, X_train, y_train, X_valid, y_valid = converting_df_to_series(X_train_df, Y_train_df, X_valid_df, Y_valid_df, X_test_df, Y_test_df)

            perturbation = "without_perturbation"
            #perturbation = "single_perturbation"
            #perturbation = "multiple_perturbation"
            #permutation_count = 5
            #X_test_df = combination_of_perturbation(X_test, y_test, X_test_df, permutation_count)

            #=============================Adversarial Attack in the test data========================
            # Define the while loop and Thread.sleep statement to be added
            ##flag=3 #Thread.sleep perturbation is applied for all other 4 category; time is applied for async and concurrency category
            ##flag="Not-Async"
            ##flag="Not-Time"
            ##flag="Not-UC"
            #X_test_df['full_code'] = deadcode_insertion(X_test, y_test, feature_types="Least") 
            #perturbation = "deadcode_perturbation"
            #X_test_df['full_code'] = printStatement_insertion(X_test, y_test, feature_types="Least")
            #perturbation = "printStatement_perturbation"
            #X_test_df['full_code'] = variableRenaming_insertion(X_test, y_test, feature_types="Most")
            #perturbation = "variableDeclare_perturbation"
            #X_test_df['full_code'] = multi_comment_insertion(X_test, y_test, feature_types="Least")
            #perturbation = "multiLine_comment_perturbation"

            #X_test_df['full_code'] = single_comment_insertion(X_test, y_test, feature_types="Least")
            #perturbation = "singleLine_comment_perturbation"

            #new_file_path = data_name+'/data_splits/X_test_fold'+str(fold)+perturbation+'_Most_important_features.csv'
            #X_test_df.to_csv(new_file_path, index=False)
            #print('X_train=', str(len(X_train)), ',y_train=',str(len(y_train)))
            #boosting_noisy_data_for_train(X_train, y_train, fold)
            #exit()

            ###FOR MAKING PERTURBED TRAINING DATA
            #X_train_df['full_code'] = deadcode_insertion(X_train, y_train) 
            #perturbation = "deadcode_perturbation"
            #X_train_df['full_code'] = printStatement(X_train, y_train)
            #perturbation = "printStatement_perturbation"
            #X_train_df['full_code'] = variableRenaming_insertion(X_train, y_train)
            #perturbation = "variableDeclare_perturbation"


            #X_train_df['full_code'] = multi_comment_insertion(X_train, y_train)
            #perturbation = "multiLine_comment_perturbation"

            #X_train_df['full_code'] = single_comment_insertion(X_train, y_train)
            #perturbation = "singleLine_comment_perturbation"
            #new_file_path = data_name+'/data_splits/X_train_fold'+str(fold)+perturbation+'.csv'
            #X_train_df.to_csv(new_file_path, index=False)

            ###FOR MAKING PERTURBED Validation DATA
            #boosting_noisy_data_for_train(X_valid, y_valid, fold) 
            #X_valid_df['full_code'] = deadcode_insertion(X_valid, y_valid) 
            #perturbation = "deadcode_perturbation"
            #X_valid_df['full_code'] = printStatement(X_valid, y_valid)
            #perturbation = "printStatement_perturbation"
            #X_valid_df['full_code'] = find_variable_declarations(X_valid, y_valid)
            #perturbation = "variableDeclare_perturbation"

            #X_valid_df['full_code'] = multi_comment_insertion(X_valid, y_valid)
            #perturbation = "multiLine_comment_perturbation"

            #X_valid_df['full_code'] = single_comment_insertion(X_valid, y_valid)
            #perturbation = "singleLine_comment_perturbation"
            #new_file_path = data_name+'/data_splits/X_valid_fold'+str(fold)+perturbation+'.csv'
            #X_valid_df.to_csv(new_file_path, index=False)

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
            #print('Original Labels')
            #print(test_y.numpy())
        
            #train_seq, train_mask, test_seq, test_mask = text_to_tensors(tokens_train, tokens_test)

            tensor_converter = TensorConverter()
            train_seq, train_mask = tensor_converter.convert_train_to_tensors(tokens_train)
            test_seq, test_mask = tensor_converter.convert_test_to_tensors(tokens_test)

            # create data_loaders for train and validation dataset
            #train_dataloader = data_loaders(train_seq, train_mask, train_y)
            batch_size = 1

            data_loader_factory = DataLoaderFactory(batch_size, seed_worker)
            train_dataloader = data_loader_factory.create_train_loader(train_seq, train_mask, train_y)
        
            model = BERT_Arch(auto_model, output_layer)
        
            
            print(model_weights_path+str(fold)+'_with_noisy_train_data.pt') 
            '''exit()
            model.load_state_dict(torch.load(model_weights_path+str(fold)+'.pt'))'''

            #model.load_state_dict(torch.load(model_weights_path+str(fold)+'_With_noisy_train_data.pt'))
            #model.load_state_dict(torch.load(model_weights_path+str(fold)+'_Only_noisy_train_1024_data.pt'))
            model.load_state_dict(torch.load(model_weights_path+str(fold)+'.pt'))
            
            #print(model_weights_path+str(fold)+'.pt') 
            #model.load_state_dict(torch.load(model_weights_path+str(fold)+'.pt'))

            model.to(device)
            model.eval()
            start_time = time.time()
            bert_flag=1
            #print("label=", str(label), " fold=", str(fold))
            attributions_dir="Example_attributions_"+perturbation+"/"

            if not os.path.exists(attributions_dir):
                os.mkdir(attributions_dir)
            with torch.no_grad():
                print('X_test=', X_test)
                print('y_test=', y_test)
                preds, html_content, attribution_csvfile_name, confidence_scores = give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold, label, y_test, dataset_category, attributions_dir, calculate_attribution)
                #exit()
                print(preds)
                print('***************=========********')
                #exit()
                #for test_case, pred in zip(X_test, preds):
                #    print(f"X_test={test_case}\nPreds={pred}\n")
                y_true_values = y_test['which_tests'].values
                for test_case, pred, y_true in zip(X_test, preds, y_true_values):
                    print(f"X_test={test_case}\n Preds={pred} True Label={y_true}\n")
                #with open("confidence_scores/2_percent_perturb_data_in_training", 'a', newline='') as file:
                with open("confidence_scores/Result_perturb_test_data", 'a', newline='') as file:
                    writer = csv.writer(file)

                    #flat_list_ground_truth =  [item[0] for item in y_test.values]
                    #writer.writerow(flat_list_ground_truth)
                    #writer.writerow(perturbation)
                    flat_list = [item[0] for item in preds]
                    writer.writerow(flat_list)
                    
                    rounded_confidence_scores = [round(score, 3) for score in confidence_scores]
                    writer.writerow(rounded_confidence_scores)
                    writer.writerow("****")
                #exit() 
                if html_content and calculate_attribution:
                    saved_html_file_name = attributions_dir+dataset_category+ "_attributions_category_"+str(label)+"_fold_"+str(fold)+".html"
                    if os.path.exists(saved_html_file_name):
                        os.remove(saved_html_file_name)
                    with open(saved_html_file_name, 'a') as file:
                        file.write(html_content)
                    output_dir_detokenization = attributions_dir+"detokenization/"
                    if not os.path.exists(output_dir_detokenization):
                        os.makedirs(output_dir_detokenization, exist_ok=True)
                    #print(["python3", "detokenization.py", attribution_csvfile_name, output_dir_detokenization, dataset_category, str(label), str(fold)])
                    #print('DIR not exists, now to create')
                    os.environ["TOKENIZERS_PARALLELISM"] = "false"
                    filename_for_detokenization = output_dir_detokenization+dataset_category+"_category_"+str(label)+"_fold_"+str(fold)
                        #os.makedirs(output_dir_detokenization, exist_ok=True)
                    subprocess.run(["python3", "detokenization.py", attribution_csvfile_name, output_dir_detokenization, dataset_category, str(label), str(fold)])
	    	
                preds_array = np.array(preds)
                arr_reshaped = preds_array.reshape(1, -1)
                 # Convert the reshaped array to a string with desired formatting
                arr_str = ', '.join(map(str, arr_reshaped[0]))
                result_str = f"Fold{fold}: {arr_str}"

                original_values_list = Y_test_df['category'].tolist()
                original_y_test = ', '.join(map(str, original_values_list))
                #print(original_y_test)
                original_y_test_str = f"Original: {original_y_test}"
                with open(where_data_comes+"-result/"+perturbation+".txt" , 'a') as file:
                    file.write(original_y_test_str)
                    file.write('\n')
                    file.write(result_str)
                    file.write('\n')
            feature_extraction_time = time.time() - start_time
            #exit()
            #print(y_test)
            #print(preds)

            y_test_for_cr = np.array(y_test).astype(int)
            preds_for_cr = np.array(preds).astype(int)

            #all_classes = list(range(max(max(y_test_for_cr), max(preds_for_cr)) + 1))
            cr=classification_report(y_test, preds, zero_division=0)
            print(cr)
            #exit()
            category_dict=parse_cr(cr, technique, str(fold))
            #exit()
            #cr=classification_report(test_y, preds)
            #parse_cr(cr, technique, str(fold), str(feature_extraction_time), str(total_execution_time), str(fit_time))
            
            #print(type(cr))
            with open(where_data_comes+"-result/without_adversarial_"+technique+"_classification_report.txt", "a") as file:
                file.write(technique+",Fold="+str(fold)+"\n")
                file.write(cr)
                file.write("\n")
                #file.write(","+str(total_execution_time))
        
            cm = confusion_matrix(y_test, preds)
        	
            with open(where_data_comes+"-result/without_adversarial_"+technique+"_confusion_matrix_val.txt", "a") as file:
                file.write(technique+",Fold="+str(fold)+"\n")
                file.write(np.array2string(cm))
                file.write("\n")
            
            del model
            print("delete model")
            torch.cuda.empty_cache()
        #exit() 
            #fold = fold + 1
        
        with open("../flaky-test-categorization/without_adversarial_per_Category_Evaluation_"+ml_technique+".txt", "w") as file:
            file.write("")
        for cls in range(output_layer):
            cls=str(cls)
            #print(cls)
            avg_category_dict =  [(category_dict[cls][idx] /category_dict[cls][-1]) for idx in range(3)] 
            print(avg_category_dict)
            with open("../flaky-test-categorization/without_adversarial_per_Category_Evaluation_"+ml_technique+".txt", "a") as file:
                file.write(cls+":" + str(avg_category_dict))
                file.write("\n")

def initialize_environment(seed_value):
    """Initializes the environment by setting the seed and configuring logging."""
    set_seed(seed_value)  # Set the seed for reproducibility
    setup_logging()  # Setup standardized logging

if __name__ == "__main__":
    dataset_path = sys.argv[1]
    model_weights_path = sys.argv[2]
    results_file = sys.argv[3]
    data_name = sys.argv[4]
    print('*************data_name=', data_name)
    #exit()
    technique = sys.argv[5]
    initialize_environment(42)
    run_experiment(dataset_path, model_weights_path, results_file, data_name, technique)
