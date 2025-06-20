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
from codebert_model import BERT_Arch
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, codebert_model_define
from data_processing import sampling, Tokenizer, TensorConverter, DataLoaderFactory
import inspect
from torch.utils.tensorboard import SummaryWriter
from sklearn.metrics import f1_score

def add_comments():
    print('Will write ')
    while_loop = "int i = 0;\nwhile(false){\n"
    sleep_statement = " //System.out.println(""In the future I will add Thread.sleep"");\n" * 10
    closing_brace = "}\n"
    
    # Combine the while loop, sleep statements, and closing brace
    code_to_add = while_loop + sleep_statement + closing_brace

    for idx, (code, category) in enumerate(zip(X_train, Y_train)):
        if category != 0: # Ignoring async category to add thread.sleep
            updated_code = code + "\n" + code_to_add
            X_train.iloc[idx] = updated_code 
    X_train_df['full_code'] = X_train

    new_file_path = data_name+'/data_splits/X_train_fold'+str(fold_number)+'_updated.csv'
    X_train_df.to_csv(new_file_path, index=False)


def initialize_environment(seed_value):
    """Initializes the environment by setting the seed and configuring logging."""
    set_seed(seed_value)  # Set the seed for reproducibility
    setup_logging()  # Setup standardized logging

def sampling(X_train, y_train, X_valid, y_valid):
    oversampling = RandomOverSampler(sampling_strategy='minority', random_state=49)

    x_train = X_train.values.reshape(-1, 1)
    y_train = y_train.values.reshape(-1, 1)
    x_val = X_valid.values.reshape(-1, 1)
    y_val = y_valid.values.reshape(-1, 1)

    x_train, y_train = oversampling.fit_resample(x_train, y_train)
    x_val, y_val = oversampling.fit_resample(x_val, y_val)

    # Restore the column names as 'full_code' for X and 'category' for y
    x_train = pd.DataFrame(x_train.ravel(), columns=['full_code'])
    y_train = pd.Series(y_train.ravel(), name='which_tests')
    x_val = pd.DataFrame(x_val.ravel(), columns=['full_code'])
    y_val = pd.Series(y_val.ravel(), name='which_tests')

    return x_train, y_train, x_val, y_val

# give test data to the model in chunks to avoid Cuda out of memory error
def give_test_data_in_chunks(x_test, tokenizer, model, device): #BERT
    #max_length = 1024
    max_length = 512
    n = len(x_test) / 50 
    preds_chunks = None
    for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
        tokens_test = tokenizer.batch_encode_plus(x_test_chunk.tolist(), max_length=max_length, pad_to_max_length=True, truncation=True)
        test_seq = torch.tensor(tokens_test['input_ids'])
        test_mask = torch.tensor(tokens_test['attention_mask'])
        preds_chunk = model(test_seq.to(device), test_mask.to(device))
        preds_chunk = preds_chunk.detach().cpu().numpy()
        preds_chunks = preds_chunk if preds_chunks is None else np.append(preds_chunks, preds_chunk, axis=0)
        preds = np.argmax(preds_chunks, axis=1)

    return preds

def preprocess_data(dataset_path, technique):
    df = pd.read_csv(dataset_path)
    input_data = df['full_code']
    dataset_category = technique.split("-")[1]
    target_df = pd.DataFrame()
    if dataset_category == "Flakicat":
        output_layer = 6 # By adding non-flaky category
        target_data = df['category']
    elif dataset_category == "IDoFT_6Cat" or dataset_category == "IDoFT_6CatStructurePrune" or dataset_category == "IDoFT_6CatUnStructurePrune":
        output_layer = 7
        target_data = df['category']
    elif dataset_category == "IDoFT_2Cat":
        output_layer = 2
        target_df['category'] = df['flaky']
        # = target_series
        target_data = target_df['category']
    return input_data, target_data, output_layer

def calculate_train_and_validation_loss(model_weights_path, fold_number, model, train_dataloader, val_dataloader, cross_entropy, device, optimizer, epochs, writer):
    early_stopping = EarlyStopping(patience=5, verbose=True, path=model_weights_path+str(fold_number)+'.pt')
    best_valid_loss = float('inf')
    best_f1_score = 0.0
    # Log the model architecture (ensure it's logged only once at the beginning of training)
    sample_input = next(iter(train_dataloader))[0].to(device)  # Get a sample input from train_dataloader
    sample_mask = next(iter(train_dataloader))[1].to(device)  # Get a sample mask
    writer.add_graph(model, (sample_input, sample_mask))  # Log the model graph
 
    # empty lists to store training and validation loss of each epoch
    train_losses = []
    valid_losses = []
    # for each epoch
    for epoch in range(epochs):
        print('\n Epoch {:} / {:}'.format(epoch + 1, epochs))
        train(model, train_dataloader, cross_entropy, device, optimizer)

        train_loss, train_preds, train_labels = evaluate(model, train_dataloader, cross_entropy, device)
        valid_loss, val_preds, val_labels = evaluate(model, val_dataloader, cross_entropy, device)
        
        # Ensure that train_loss and valid_loss are scalar values
        train_loss = train_loss.item() if isinstance(train_loss, torch.Tensor) else train_loss
        valid_loss = valid_loss.item() if isinstance(valid_loss, torch.Tensor) else valid_loss

        # Convert predictions to class labels and compute accuracy
        #train_labels = np.concatenate([batch[-1].cpu().numpy() for batch in train_dataloader])  # True labels
        #val_labels = np.concatenate([batch[-1].cpu().numpy() for batch in val_dataloader])  # True labels

        # Get predicted class from probabilities
        train_preds_class = np.argmax(train_preds, axis=1)
        val_preds_class = np.argmax(val_preds, axis=1)
        # Compute accuracy
        train_acc = np.mean(train_preds_class == train_labels)
        valid_acc = np.mean(val_preds_class == val_labels)
 
        # Compute F1-score
        train_f1 = f1_score(train_labels, train_preds_class, average='weighted')  # Weighted F1-score for imbalanced data
        valid_f1 = f1_score(val_labels, val_preds_class, average='weighted')  # Weighted F1-score for validation

        # Log F1-score to TensorBoard
        writer.add_scalar(f'F1_Score/train_fold_{fold_number}', train_f1, epoch)
        writer.add_scalar(f'F1_Score/valid_fold_{fold_number}', valid_f1, epoch)

        # Log accuracy to TensorBoard
        writer.add_scalar(f'Accuracy/train_fold_{fold_number}', train_acc, epoch)
        writer.add_scalar(f'Accuracy/valid_fold_{fold_number}', valid_acc, epoch)
        # Log training and validation loss to TensorBoard (single graph)
        writer.add_scalars(f'Loss/fold_{fold_number}', {
            'train': train_loss,
            'valid': valid_loss
        }, epoch)
        
        # Log training and validation accuracy to TensorBoard (single graph)
        writer.add_scalars(f'Accuracy/fold_{fold_number}', {
            'train': train_acc,
            'valid': valid_acc
        }, epoch)

         # Log training and validation F1-score to TensorBoard (single graph)
        writer.add_scalars(f'F1_Score/fold_{fold_number}', {
            'train': train_f1,
            'valid': valid_f1
        }, epoch)  

        # EarlyStopping needs to check if validation loss has improved
        early_stopping(valid_loss, model)
        if early_stopping.early_stop:
            print("Early stopping")
            break

        '''early_stopping(valid_f1, model)
        if early_stopping.early_stop:
            print("Early stopping")
            break'''
    
        print("Forward method signature:", inspect.signature(model.forward))
        if valid_loss < best_valid_loss:
        #if valid_f1 > best_f1_score:
            best_valid_loss = valid_loss
            #best_f1_score = valid_f1
            #torch.save(model.state_dict(), model_weights_path+str(fold_number)+'_adversarial_training.pt')
            torch.save(model.state_dict(), model_weights_path+str(fold_number)+'_Only_noisy_train_1024_data.pt')
            #torch.save(model.state_dict(), model_weights_path+str(fold_number)+'_With_noisy_train_data.pt')
            #torch.save(model.state_dict(), model_weights_path+str(fold_number)+'.pt')
    
        train_losses.append(train_loss)
        valid_losses.append(valid_loss)
    
        print(f'\nTraining Loss: {train_loss:.3f}, accuracy: {train_acc}, f1: {train_f1}')
        print(f'Validation Loss: {valid_loss:.3f}, accuracy: {valid_acc}, f1: {valid_f1}')

    return model_weights_path

def dir_or_file_create(where_data_comes, data_name):
    exists1=os.path.exists(where_data_comes+"-result")
    if not exists1:
        os.mkdir(where_data_comes+"-result")
    
    if not os.path.exists(data_name):
        os.mkdir(data_name)
    
    if not os.path.exists(data_name+'/data_splits'):
        os.mkdir(data_name+'/data_splits')

def create_tensor_and_data_loader(tokens_train, tokens_val, tokens_test, batch_size, seed_worker, train_y, val_y):
    tensor_converter = TensorConverter()
    train_seq, train_mask = tensor_converter.convert_train_to_tensors(tokens_train)
    val_seq, val_mask = tensor_converter.convert_val_to_tensors(tokens_val)
    test_seq, test_mask = tensor_converter.convert_test_to_tensors(tokens_test)

    
    data_loader_factory = DataLoaderFactory(batch_size, seed_worker)
    train_dataloader = data_loader_factory.create_train_loader(train_seq, train_mask, train_y)
    val_dataloader = data_loader_factory.create_val_loader(val_seq, val_mask, val_y)
    return train_dataloader, val_dataloader

def make_data_csv(X_train, y_train, X_valid, y_valid, X_test, y_test, fold_number, data_name):
    pd.DataFrame(X_train).to_csv(data_name+'/data_splits/X_train_fold'+str(fold_number)+'.csv', index=False)
    pd.DataFrame(y_train).to_csv(data_name+'/data_splits/y_train_fold'+str(fold_number)+'.csv', index=False)
    
    # Save validation data
    pd.DataFrame(X_valid).to_csv(data_name+'/data_splits/X_valid_fold'+str(fold_number)+'.csv', index=False)
    pd.DataFrame(y_valid).to_csv(data_name+'/data_splits/y_valid_fold'+str(fold_number)+'.csv', index=False)

    # Save validation data
    pd.DataFrame(X_test).to_csv(data_name+'/data_splits/X_test_fold'+str(fold_number)+'.csv', index=False)
    pd.DataFrame(y_test).to_csv(data_name+'/data_splits/y_test_fold'+str(fold_number)+'.csv', index=False)
    

def run_experiment(dataset_path, model_weights_path, results_file, data_name, technique):
    # specify GPU
    device = torch.device("cuda")
    print(torch.cuda.is_available())  # This should return True if CUDA is available


    input_data, target_data, output_layer = preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]


    no_splits = 5 # For FlakiCat=4, IDOFT=10
    skf = StratifiedKFold(n_splits=no_splits,shuffle=True)
    TN = FP = FN = TP = 0
    fold_number = 0
    input_data, target_data, output_layer = preprocess_data(dataset_path, technique) 
    dir_or_file_create(where_data_comes, data_name) #Result dir create
    
    model_name, tokenizer, auto_model = codebert_model_define()
    total_execution_time = 0    
    total_fine_tuning_time=0
    #print(len(input_data))
    for fold_number in range(no_splits):
    #for train_index, test_index in skf.split(input_data, target_data):
        print('fold_number=',fold_number)
        #X_train, X_test = input_data.iloc[list(train_index)], input_data.iloc[list(test_index)]
        #y_train, y_test = target_data.iloc[list(train_index)], target_data.iloc[list(test_index)]
        #pd.DataFrame(X_test).to_csv(data_name+'/data_splits/X_test_fold'+str(fold_number)+'.csv', index=False)
        #pd.DataFrame(y_test).to_csv(data_name+'/data_splits/y_test_fold'+str(fold_number)+'.csv', index=False)
    
        ## Split train data into train and validation sets
        #X_train, X_valid, y_train, y_valid = train_test_split(X_train, y_train, random_state=49, test_size=0.1, stratify=y_train)
        ##X_train_df = pd.DataFrame(X_train)
        #make_data_csv(X_train, y_train, X_valid, y_valid, X_test, y_test, fold_number, data_name)
        ##X_train, y_train = sampling(X_train, y_train)
        # Load training, validation, and testing data from CSV files for the current fold

        #X_train = pd.read_csv(data_name + '/data_splits/X_train_fold' + str(fold_number) + '.csv')
        #y_train = pd.read_csv(data_name + '/data_splits/y_train_fold' + str(fold_number) + '.csv')

        #X_valid = pd.read_csv(data_name + '/data_splits/X_valid_fold' + str(fold_number) + '.csv')
        #y_valid = pd.read_csv(data_name + '/data_splits/y_valid_fold' + str(fold_number) + '.csv')

        '''X_train = pd.read_csv(data_name + '/data_splits/X_train_fold' + str(fold_number) + '_with_noisy_data.csv')
        y_train = pd.read_csv(data_name + '/data_splits/y_train_fold' + str(fold_number) + '_with_noisy_data.csv')

        X_valid = pd.read_csv(data_name + '/data_splits/X_valid_fold' + str(fold_number) + '_with_noisy_data.csv')
        y_valid = pd.read_csv(data_name + '/data_splits/y_valid_fold' + str(fold_number) + '_with_noisy_data.csv')'''


        X_train = pd.read_csv(data_name + '/data_splits/X_train_fold' + str(fold_number) + '_only_noisy_data.csv')
        y_train = pd.read_csv(data_name + '/data_splits/y_train_fold' + str(fold_number) + '_only_noisy_data.csv')

        X_valid = pd.read_csv(data_name + '/data_splits/X_valid_fold' + str(fold_number) + '_only_noisy_data.csv')
        y_valid = pd.read_csv(data_name + '/data_splits/y_valid_fold' + str(fold_number) + '_only_noisy_data.csv')

        X_test = pd.read_csv(data_name + '/data_splits/X_test_fold' + str(fold_number) + '.csv')
        y_test = pd.read_csv(data_name + '/data_splits/y_test_fold' + str(fold_number) + '.csv')

 
        tokenizer_instance = Tokenizer(tokenizer)
        #print(X_train.head())

        tokens_train = tokenizer_instance.tokenize_training_data(X_train['full_code'])
        #exit()
        '''tokens_val = tokenizer_instance.tokenize_validation_data(X_valid)
        tokens_test = tokenizer_instance.tokenize_test_data(X_test)'''
        #tokens_train = tokenizer_instance.tokenize_training_data(X_train['full_code'])

        tokens_val = tokenizer_instance.tokenize_validation_data(X_valid['full_code'])
        tokens_test = tokenizer_instance.tokenize_test_data(X_test['full_code'])

        Y_train = pd.DataFrame(y_train)
        y_val = pd.DataFrame(y_valid)
        y_test = pd.DataFrame(y_test)
    
        Y_train.columns = ['which_tests']
        y_val.columns = ['which_tests']
        y_test.columns = ['which_tests']
    
        # convert labels of train, validation and test into tensors
        train_y = torch.tensor(Y_train['which_tests'].values)
        val_y = torch.tensor(y_val['which_tests'].values)
        test_y = torch.tensor(y_test['which_tests'].values)
    
        # create data_loaders for train and validation dataset
        batch_size = 8  # Define the batch size
        #train_seq, train_mask, val_seq, val_mask, test_seq, test_mask = text_to_tensors(tokens_train, tokens_val, tokens_test)
        train_dataloader, val_dataloader = create_tensor_and_data_loader(tokens_train, tokens_val, tokens_test, batch_size, seed_worker, train_y, val_y)
        #print('******************')
        #exit()
        # compute the class weights
        #class_weights = compute_class_weight('balanced', np.unique(Y_train), y=np.ravel(Y_train))
        class_weights = compute_class_weight('balanced', classes=np.unique(Y_train['which_tests']), y=np.ravel(Y_train['which_tests'].values))
        class_counts = np.bincount(Y_train['which_tests'])
        class_counts_val = np.bincount(y_val['which_tests'])
        print("Class Distribution:", class_counts)
        print("Class Distribution:", class_counts_val)
        # Print the unique classes and their corresponding weights
        unique_classes = np.unique(Y_train['which_tests'])
        print("Unique Classes:", unique_classes)
        print("Class Weights:", class_weights)
        #exit()
        # convert list of class weights to a tensor
        weights = torch.tensor(class_weights, dtype=torch.float)
        weights = weights.to(device)
        cross_entropy = nn.NLLLoss(weight=weights)
        #cross_entropy = nn.NLLLoss()
        epochs = 20
        model = BERT_Arch(auto_model, output_layer)
        model = model.to(device)
    
    	# Define loss function and optimizer for the quantization-aware model
        optimizer = AdamW(model.parameters(), lr=1e-5) #, weight_decay=1e-2)
        # define the optimizer
        gc.collect()
        torch.cuda.empty_cache()
        # set initial loss to infinite
        
        #Start time   
        best_model=model
        start_time = time.time()
        #print(model_weights_path+str(fold_number)+'.pt')
        # Initialize TensorBoard writer
        writer = SummaryWriter(log_dir=f"runs/experiment_{fold_number}")
        model_weights_path = calculate_train_and_validation_loss(model_weights_path, fold_number, model, train_dataloader, val_dataloader, cross_entropy, device, optimizer, epochs, writer)    
        writer.close()
        total_fine_tuning_time+=(time.time() - start_time)
        fold_number +=1
    
        # load weights of best model
        #model.load_state_dict(torch.load(model_weights_path+str(fold_number)+'_Only_noisy_train_data.pt'))
    
        '''with torch.no_grad():
            start_time = time.time()
            preds = give_test_data_in_chunks(X_test, tokenizer, model, device)
            total_execution_time+=(time.time() - start_time)
    
        cr=classification_report(test_y, preds)
        print(type(cr))
        parse_cr(cr, technique, str(fold_number))
    
        with open(where_data_comes+"-result/classification_report_"+str(no_splits)+"folds_"+str(epochs)+"_epoch.txt", "a") as file:
            file.write("Fold="+str(fold_number)+"\n")
            file.write(cr)
            file.write("\n")
    
        cm = confusion_matrix(test_y, preds)'''
        #print(cm)
    	
        '''with open(where_data_comes+"-result/confusion_matrix_"+str(no_splits)+"folds_"+str(epochs)+"_epoch.txt", "a") as file:
            file.write("Fold="+str(fold_number)+"\n")
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
    
        #fold_number = fold_number+1

if __name__ == "__main__":
    dataset_path = sys.argv[1]
    model_weights_path = sys.argv[2]
    results_file = sys.argv[3]
    data_name = sys.argv[4]
    technique = sys.argv[5]
    initialize_environment(42)
    run_experiment(dataset_path, model_weights_path, results_file, data_name, technique)
