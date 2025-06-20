import matplotlib.pyplot as plt
import torch
import shap
import pickle
import numpy as np
import scipy as sp
import pandas as pd 

def get_features_for_a_category(cohorts, category_name, fold, data_name):
    cohort_labels = list(cohorts.keys())
    cohort_exps = list(cohorts.values())
    features = cohort_exps[0].data
    feature_names = cohort_exps[0].feature_names
    values = np.array([cohort_exps[i].values for i in range(len(cohort_exps))]).T
    
    true_pair_df = pd.DataFrame({'Data':feature_names, 'Values': values[:,0]})
    csv_filename ='shap_features/fold_' + str(fold)+ '_' + data_name +'_'+str(category_name)+'_shap_values.csv'  # Added underscore
    true_pair_df.to_csv(csv_filename, index=False)

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
    max_length = 512
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
##Explainablibility, Shap
#id2label = {0: 'NDOD', 1: 'NOD', 2: 'OD', 3: 'ID', 4: 'NIO', 5: 'UD'}
def flakicat_explain(tokenizer, model, device, dataset_category, fold, X_test, output_layer, data_name):
    id2label = {0: 'async wait', 1: 'concurrency', 2: 'time', 3: 'unordered collections', 4: 'test order dependency', 5: 'non-flaky'}
    labels = list(id2label.values())
    label2id = {}
    for j,label in enumerate(labels):
        label2id[label]=j
    
    
    #shap_values_multiclass = explainer(X_test)
    f_with_tokenizer = get_f_with_tokenizer(tokenizer, model, device)
    
     #===========Needed only for training===============
    with torch.no_grad():
        explainer = shap.Explainer(f_with_tokenizer, tokenizer, output_names=labels, output_shape=(X_test.shape[0], output_layer))
        shap_values_multiclass = explainer(X_test)
    
    with open("shap_model/shap_values_multiclass"+"_"+str(dataset_category)+"_"+str(fold)+".pkl", "wb") as fl:
        pickle.dump(shap_values_multiclass, fl)
    
    # Load the saved shap_values_multiclass object
    with open("shap_model/shap_values_multiclass"+"_"+str(dataset_category)+"_"+str(fold)+".pkl", "rb") as fl:
        shap_values_multiclass = pickle.load(fl)
    
    shap_values_matrix = shap_values_multiclass.values.reshape(X_test.shape[0], -1) #shap_values.reshape(shap_values.shape[0], -1)
    #print(shap_values_multiclass[0])
    
    shap_values_asyn_wait = shap_values_multiclass.mean(0)[:, label2id['async wait']] 
    cohorts = {"": shap_values_asyn_wait}
    get_features_for_a_category(cohorts, 'async wait', fold, data_name) 
    
    shap_values_asyn_wait = shap_values_multiclass.mean(0)[:, label2id['concurrency']] 
    cohorts = {"": shap_values_asyn_wait}
    get_features_for_a_category(cohorts, 'concurrency', fold, data_name) 
    
    shap_values_asyn_wait = shap_values_multiclass.mean(0)[:, label2id['time']] 
    cohorts = {"": shap_values_asyn_wait}
    get_features_for_a_category(cohorts, 'time', fold, data_name) 
    
    shap_values_asyn_wait = shap_values_multiclass.mean(0)[:, label2id['unordered collections']] 
    cohorts = {"": shap_values_asyn_wait}
    get_features_for_a_category(cohorts, 'unordered collections', fold, data_name) 
    
    shap_values_asyn_wait = shap_values_multiclass.mean(0)[:, label2id['test order dependency']] 
    cohorts = {"": shap_values_asyn_wait}
    get_features_for_a_category(cohorts, 'test order dependency', fold, data_name)
    
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
