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
from codet5_model import CodeT5_Arch
from torch.quantization import fuse_modules
from codebert_model import BERT_Arch
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, codet5_model_define
from data_processing import sampling, Tokenizer, TensorConverter, DataLoaderFactory
#from renaming_variable import rename_variables_in_code
import torch.backends.cudnn as cudnn
from perturbation import printStatement, deadcode_insertion, find_variable_declarations
from captum.attr import IntegratedGradients, LayerConductance, LayerIntegratedGradients
import matplotlib.pyplot as plt
from interpret import show
from interpret.blackbox import ShapKernel
from functools import partial
from shap_explainer import flakicat_explain 
from captum.attr import visualization
from selenium import webdriver
import time
import io
from contextlib import redirect_stdout
from IPython.core.display import display, HTML
from captum.attr import visualization as viz
from bs4 import BeautifulSoup
import subprocess

vis_data_records_ig = []

#def prepare_data_for_shap(test_seq, test_mask):
#    # Ensure data is on CPU as numpy arrays for SHAP
#    #return [(seq.cpu().numpy(), mask.cpu().numpy()) for seq, mask in zip(test_seq, test_mask)]
#    return [np.hstack((seq.cpu().numpy(), mask.cpu().numpy())) for seq, mask in zip(test_seq, test_mask)]

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


def add_attributions_to_visualizer(attributions, tokens, pred_class, pred_logit, label, delta, vis_data_records, test_y):
    attributions = attributions / torch.norm(attributions)
    attributions = attributions.detach().cpu().numpy()
    pred_list = pred_class.tolist() if isinstance(pred_class, np.ndarray) else pred_class
    #print(pred_list)
    #print('original=',test_y)
    flat_tokens = tokens[0]
    # storing couple samples in an array for visualization purposes
    vis_data_records.append(visualization.VisualizationDataRecord(
                            attributions,
                            pred_list[0],
                            pred_logit,
                            label,
                            "label",
                            attributions.sum(),       
                            flat_tokens[:len(attributions)],
                            delta))    

def plot_text_attributions(total_tokens, total_attributions, save_path=None):
    max_width = 2000
    for i, (token_list, attribution_list) in enumerate(zip(total_tokens, total_attributions)):
		# Adjust width dynamically based on the number of tokens, ensuring each token has adequate space
        fig_width = min(max_width, max(20, len(token_list) * 0.5))
        fig_height = 4  # Increase height for better visibility
        plt.figure(figsize=(10, 4), dpi=100)

        if isinstance(attribution_list, torch.Tensor):
            attribution_list = attribution_list.cpu().detach().numpy()

        max_val = np.max(attribution_list)
        normalized_attributions = attribution_list / max_val if max_val > 0 else attribution_list
        colors = plt.cm.viridis(normalized_attributions)
        font_size = min(16, 800 / len(token_list))

        for j, (token, color) in enumerate(zip(token_list, colors)):
            plt.text(j, 0, token, color=color, ha='center', va='center', fontsize=font_size)

        plt.xticks([])
        plt.yticks([])
        plt.title(f"Attribution Plot for Instance {i+1}", fontsize=font_size)
        plt.savefig(f"attributions/attribution_{i+1}.png", bbox_inches='tight')
        plt.close()  # Close the figure to free memory


def save_attributions(tokens, attributions, predictions, filepath, ground_truth, pred_logit):
    flat_tokens = [item for sublist in tokens for item in sublist] if isinstance(tokens[0], list) else tokens
    flat_attributions = attributions.tolist() if isinstance(attributions, torch.Tensor) else attributions 
    #print(type(pred_logit))
    data = [
        {'Token': token, 'Attribution': attr, 'Predicted_class': predictions, 'True_class':ground_truth, 'Pred_logit':pred_logit[0]} 
        for token, attr in zip(flat_tokens, flat_attributions)
        if token != '<pad>'
    ]
    df = pd.DataFrame(data)
    df.to_csv(filepath, index=False, mode='a')

def give_test_data_in_chunks(x_test_nparray, tokenizer, model, batch_size, device, fold, label, Y_test, dataset_category): #BERT
    #max_length = 1024; 128
    max_length = 512
    x_test = pd.DataFrame(x_test_nparray)
    n = 1 #len(x_test) / batch_size
    preds_chunks = None
    paired_data = []
    model.eval()
    total_attributions = []
    total_tokens = []
    total_preds = []
    vis_data_records_ig = []
    count = 0
    #attribution_csvfile_name = "attributions/"+dataset_category+"_attributions_category_"+str(label)+"_fold_"+str(fold)+".csv"
    #if os.path.exists(attribution_csvfile_name):
    #    os.remove(attribution_csvfile_name) 
    for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
        count +=1
        # Ensure x_test_chunk is a DataFrame
        if isinstance(x_test_chunk, pd.Series):
            x_test_chunk = x_test_chunk.to_frame().T
        # Convert DataFrame to list of strings
        test_data = x_test_chunk.iloc[:, 0].tolist() if len(x_test_chunk) > 1 else [x_test_chunk.iloc[0, 0]]
        test_y = Y_test['which_tests'].iloc[g]
        tokens_test = tokenizer.batch_encode_plus(test_data, max_length=max_length, pad_to_max_length=True, truncation=True)
        test_seq = torch.tensor(tokens_test['input_ids']).to(device)
        test_mask = torch.tensor(tokens_test['attention_mask']).to(device)
        preds_chunk = model(test_seq, test_mask)
        preds_chunk = preds_chunk.detach().cpu().numpy()
        pred_class = np.argmax(preds_chunk, axis=1)
        pred_logit = preds_chunk[0, pred_class]
        total_preds.append(pred_class)

        #lig = LayerIntegratedGradients(model, model.bert.embeddings.word_embeddings) # Adjust layer as needed
        #attributions, delta = lig.attribute(inputs=test_seq, baselines=test_seq * 0, additional_forward_args=(test_mask), target=label, return_convergence_delta=True, n_steps=2)  # target can be modified based on specific output
        #attributions = attributions.sum(dim=-1).squeeze(0)  # Summing over the embedding dimension if necessary

        #tokens = [tokenizer.convert_ids_to_tokens(id) for id in test_seq.cpu().numpy()]
        #save_attributions(tokens, attributions.cpu().numpy(), pred_class, attribution_csvfile_name, test_y, pred_logit)
        #add_attributions_to_visualizer(attributions, tokens, pred_class, pred_logit, label, delta, vis_data_records_ig, test_y)

    #html_obj = viz.visualize_text(vis_data_records_ig)
    #html_content = html_obj.data 
    #html_content = html_content.replace('True Label', 'Target Label')

    #soup = BeautifulSoup(html_content, 'html.parser')
    #rows = soup.find_all('tr')
    #header_row = rows[0]
    #new_col_header = soup.new_tag('th')
    #new_col_header.string = 'Ground Truth'
    ##header_row.append(new_col_header)
    #header_row.insert(1, new_col_header)

    #data_rows_start = 1
    #for idx, (row, test_value) in enumerate(zip(rows[data_rows_start::2], Y_test['which_tests']), start=data_rows_start):
    #    new_col_data = soup.new_tag('td')
    #    new_col_data.string = str(test_value)
    #    #print('********Ground-truth=', str(test_value))
    #    row.insert(1, new_col_data)

    #modified_html_content = str(soup)

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
def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    #device = torch.device("cuda")
    device = torch.device("cpu")
    ml_technique=technique.split("-")[0]
    input_data, target_data, output_layer, dataset_category = preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0] 
    model_name, tokenizer, auto_model = codet5_model_define()

    execution_time = time.time()
    #print("Start time of the experiment", execution_time)
    no_split=10 # For Flakicat (10 folds)
    TN = FP = FN = TP = 0
    fold_number = 0
    
    prediction_time_codebert = 0
    
    for fold in range(no_split):
        print(fold)

        if os.path.exists("Flakicat_Categorization-result/score_fold"+str(fold)+"_Class.txt"):
            os.remove("Flakicat_Categorization-result/score_fold"+str(fold)+"_Class.txt")
        fit_time=0
        bert_flag=0
        total_execution_time = 0
        feature_extraction_time=0
        #total_execution_time_for_feature_extraction = 0
        print(" NOW IN FOLD NUMBER", fold_number)
    
        X_train_df = pd.read_csv(data_name+'/data_splits/X_train_fold'+str(fold)+'.csv')
        Y_train_df = pd.read_csv(data_name+'/data_splits/y_train_fold'+str(fold)+'.csv')
    
        X_test_df = pd.read_csv(data_name+'/data_splits/X_test_fold'+str(fold)+'.csv')
        Y_test_df = pd.read_csv(data_name+'/data_splits/y_test_fold'+str(fold)+'.csv')
    
        #X_test_df.columns = ['test_code']
        #Y_test_df.columns = ['label']
    
        X_test = X_test_df['full_code']
        y_test = Y_test_df['category']
    
        X_train = X_train_df['full_code']
        y_train = Y_train_df['category']
    
        perturbation = "without_perturbation"
        #=============================Adversarial Attack in the test data========================
        # Define the while loop and Thread.sleep statement to be added
        flag=3 #Thread.sleep perturbation is applied for all other 4 category; time is applied for async and concurrency category
        #flag="OneCatInject-ThreadSleep"
        #flag="OneCatInject-Time"
        #flag="OneCatInject-UC"
        #X_test_df['full_code'] = deadcode_insertion(X_test, y_test, flag) 
        #perturbation = "deadcode_perturbation"
        X_test_df['full_code'] = printStatement(X_test, y_test)
        perturbation = "printStatement_perturbation"
        #X_test_df['full_code'] = find_variable_declarations(X_test, y_test)
        #perturbation = "variableDeclare_perturbation"
        #X_test_df['full_code'] = operand_mutation(X_test, y_test)
        #exit()
        #
        #new_file_path = data_name+'/data_splits/X_test_fold'+str(fold)+'.csv'
        new_file_path = data_name+'/data_splits/X_test_fold'+str(fold)+'_updated.csv'
        X_test_df.to_csv(new_file_path, index=False)
   
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
    
        model = CodeT5_Arch(auto_model, output_layer)
     
        # push the model to GPU
        model = model.to(device)
    
        #model.load_state_dict(torch.load(model_weights_path+str(fold_number)+'.pt'))
        
        start_time = time.time()
        model.to(device)
        model.eval()  # Make sure model is in eval mode

        start_time = time.time()
        bert_flag=1
        label = 0
        with torch.no_grad():
            preds = give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold, label, y_test, dataset_category)
            #saved_html_file_name = "attributions/"+dataset_category+ "_attributions_category_"+str(label)+"_fold_"+str(fold)+".html"
            #if os.path.exists(saved_html_file_name):
            #    os.remove(saved_html_file_name)

            #with open(saved_html_file_name, 'a') as file:
            #    file.write(html_content)
            #output_dir_detokenization = "attributions/detokenization/"
            #if not os.path.exists(output_dir_detokenization):
            #    os.makedirs(output_dir_detokenization, exist_ok=True)

            #print('DIR not exists, now to create')
            #os.environ["TOKENIZERS_PARALLELISM"] = "false"
            #filename_for_detokenization = output_dir_detokenization+dataset_category+"_category_"+str(label)+"_fold_"+str(fold)
                #os.makedirs(output_dir_detokenization, exist_ok=True)
            #subprocess.run(["python3", "detokenization.py", attribution_csvfile_name, output_dir_detokenization, dataset_category, str(label), str(fold)])
            #tokens = tokenizer.convert_ids_to_tokens(tokens_test['input_ids'][0])  # Assuming tokens_test is from tokeniz
            #attributions = attribution_chunks[0]  # Example attribution for the first instance
            #plot_text_attributions(total_tokens, total_attributions,"attributions/attribution"+str(fold_number)+".png") 
            #visualize_importances(total_tokens, total_attributions)

            #X_train_shap = prepare_data_for_shap(train_seq, train_mask)
            #X_test_shap = prepare_data_for_shap(test_seq, test_mask)

		
            preds_array = np.array(preds)
            arr_reshaped = preds_array.reshape(1, -1)
             # Convert the reshaped array to a string with desired formatting
            arr_str = ', '.join(map(str, arr_reshaped[0]))
            result_str = f"Fold{fold_number}: {arr_str}"

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
        #print(y_test)
        #print(preds)
        cr = classification_report(y_test, preds)
        category_dict = parse_cr(cr, technique, str(fold))
        #cr=classification_report(test_y, preds)
        #parse_cr(cr, technique, str(fold), str(feature_extraction_time), str(total_execution_time), str(fit_time))
        
        #print(type(cr))
        with open(where_data_comes+"-result/"+technique+"_classification_report.txt", "a") as file:
            file.write(technique+",Fold="+str(fold_number)+"\n")
            file.write(cr)
            file.write("\n")
            #file.write(","+str(total_execution_time))
    
        cm = confusion_matrix(y_test, preds)
    	
        with open(where_data_comes+"-result/"+technique+"_confusion_matrix_val.txt", "a") as file:
            file.write(technique+",Fold="+str(fold_number)+"\n")
            file.write(np.array2string(cm))
            file.write("\n")
        
        del model
        print("delete model")
        torch.cuda.empty_cache()
    
        fold_number = fold_number+1
    
    for cls in range(output_layer):
        cls=str(cls)
        #print(cls)
        avg_category_dict =  [(category_dict[cls][idx] /category_dict[cls][-1]) for idx in range(3)] 
        print(avg_category_dict)
        with open("../flaky-test-categorization/per_Category_Evaluation_"+ml_technique+".txt", "a") as file:
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
    technique = sys.argv[5]
    initialize_environment(42)
    run_experiment(dataset_path, model_weights_path, results_file, data_name, technique)
