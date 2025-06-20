import sys
import gc
from xgboost import XGBClassifier
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
from sklearn import metrics

# setting the seed for reproducibility
def set_deterministic(seed):
    np.random.seed(seed)
    torch.manual_seed(seed)                    
    torch.cuda.manual_seed(seed)               
    torch.cuda.manual_seed_all(seed)           
    torch.backends.cudnn.deterministic = True 

# specify GPU
device = torch.device("cuda")

# read the parameters 

dataset_path = sys.argv[1]
model_weights_path = sys.argv[2]
results_file = sys.argv[3]
ml_technique = sys.argv[4]
data_name = sys.argv[5]
where_data_comes=data_name.split("-")[0]
#processed_data_with_vocab_file= sys.argv[5]

df = pd.read_csv(dataset_path)
input_data = df['full_code'] # use the 'full_code' column to run Flakify using the full code instead of pre-processed code
print(len(input_data))
target_data = df['flaky']
print('DF head==================')
print(len(df))
print(df.head())
print(df.columns)
print('DF head==================')

#======================FlakeFlagger =============
#df_2 = pd.read_csv(processed_data_with_vocab_file) 

'''num_cols = ['test_name', 'flakyStatus','testLength', 'numCoveredLines', 'ExecutionTime', 'projectSourceLinesCovered', 
            'projectSourceClassesCovered', 'hIndexModificationsPerCoveredLine_window5', 
            'hIndexModificationsPerCoveredLine_window10', 'hIndexModificationsPerCoveredLine_window25', 
            'hIndexModificationsPerCoveredLine_window50','hIndexModificationsPerCoveredLine_window75', 
            'hIndexModificationsPerCoveredLine_window100', 'hIndexModificationsPerCoveredLine_window500',
           'hIndexModificationsPerCoveredLine_window10000', 'num_third_party_libs']'''

#df_ff=df_2[num_cols]
#print(df_ff.columns)


# balance dataset
def sampling(X_train, y_train, X_valid, y_valid):
    
    oversampling = RandomOverSampler(
        sampling_strategy='minority', random_state=49)
    x_train = X_train.reshape(-1, 1)
    y_train = y_train.reshape(-1, 1)
    x_val = X_valid.reshape(-1, 1)
    y_val = y_valid.reshape(-1, 1)
    
    x_train, y_train = oversampling.fit_resample(x_train, y_train)
    x_val, y_val = oversampling.fit_resample(x_val, y_val)
    x_train = pd.Series(x_train.ravel())
    y_train = pd.Series(y_train.ravel())
    x_val = pd.Series(x_val.ravel())
    y_val = pd.Series(y_val.ravel())

    return x_train, y_train, x_val, y_val


# define CodeBERT model
model_name = "microsoft/codebert-base"
model_config = AutoConfig.from_pretrained(model_name, return_dict=False, output_hidden_states=True)
tokenizer = AutoTokenizer.from_pretrained(model_name)
auto_model = AutoModel.from_pretrained(model_name, config=model_config)

# convert code into tokens and then vector representation
def tokenize_data(train_text, val_text, test_text):

    tokens_train = tokenizer.batch_encode_plus(
        train_text.tolist(),
        max_length=510,
        pad_to_max_length=True,
        truncation=True)

    tokens_val = tokenizer.batch_encode_plus(
        val_text.tolist(),
        max_length=510,
        pad_to_max_length=True,
        truncation=True)

    tokens_test = tokenizer.batch_encode_plus(
        test_text.tolist(),
        max_length=510,
        pad_to_max_length=True,
        truncation=True)
    return tokens_train, tokens_val, tokens_test

# convert vector representation to tensors
def text_to_tensors(tokens_train, tokens_val, tokens_test):
    train_seq = torch.tensor(tokens_train['input_ids'])
    train_mask = torch.tensor(tokens_train['attention_mask'])

    val_seq = torch.tensor(tokens_val['input_ids'])
    val_mask = torch.tensor(tokens_val['attention_mask'])

    test_seq = torch.tensor(tokens_test['input_ids'])
    test_mask = torch.tensor(tokens_test['attention_mask'])

    return train_seq, train_mask, val_seq, val_mask, test_seq, test_mask

# sett seed for data_loaders for output reproducibility
def seed_worker(worker_id):
    worker_seed = torch.initial_seed() % 2**32
    numpy.random.seed(worker_seed)
    random.seed(worker_seed)

g = torch.Generator()
seed = 42 # any number 
set_deterministic(seed)

def data_loaders(train_seq, train_mask, train_y, val_seq, val_mask, val_y, test_seq, test_mask, test_y):
    # define a batch size
    batch_size = 50
    print('From data_loader')
    # wrap tensors
    train_data = TensorDataset(train_seq, train_mask, train_y)

    # sampler for sampling the data during training
    train_sampler = RandomSampler(train_data)

    # dataLoader for train set
    train_dataloader = DataLoader(
        train_data, sampler=train_sampler, batch_size=batch_size, worker_init_fn=seed_worker)

    # wrap tensors
    val_data = TensorDataset(val_seq, val_mask, val_y)

    # sampler for sampling the data during training
    val_sampler = SequentialSampler(val_data)

    # dataLoader for validation set
    val_dataloader = DataLoader(val_data, sampler=val_sampler, batch_size=batch_size, worker_init_fn=seed_worker)

    # wrap tensors
    test_data = TensorDataset(test_seq, test_mask, test_y)

    # sampler for sampling the data during training
    test_sampler = SequentialSampler(test_data)

    # dataLoader for validation set
    test_dataloader = DataLoader(test_data, sampler=test_sampler, batch_size=batch_size, worker_init_fn=seed_worker)

    return train_dataloader, val_dataloader, test_dataloader

# set up the neural network for CodeBERT fine-tuning
class BERT_Arch(nn.Module):

    def __init__(self, bert):

        super(BERT_Arch, self).__init__()

        self.bert = auto_model

        # dropout layer
        self.dropout = nn.Dropout(0.1)

        # relu activation function
        self.relu = nn.ReLU()

        # dense layer 1
        self.fc1 = nn.Linear(768, 512)

        # dense layer 2 (Output layer)
        self.fc2 = nn.Linear(512, 2)

        # softmax activation function
        self.softmax = nn.LogSoftmax(dim=-1)

    # define the forward pass
    def forward(self, sent_id, mask):

        # pass the inputs to the model
        #print(sent_id.shape)
        #print(mask.shape)
        
        cls_hs = self.bert(sent_id, attention_mask=mask)[1]
        #print(cls_hs.shape)

        fc1_output = self.fc1(cls_hs)

        relu_output = self.relu(fc1_output)

        dropout_output = self.dropout(relu_output)

        # output layer
        fc2_output = self.fc2(dropout_output)

        # apply softmax activation
        final_output = self.softmax(fc2_output)

        return final_output

# train the model
def train():

    model.train()

    total_loss, total_accuracy = 0, 0

    # empty list to save model predictions
    total_preds = []

    # iterate over batches
    for step, batch in enumerate(train_dataloader):

        # progress update after every 50 batches.
        if step % 50 == 0 and not step == 0:
            print('  Batch {:>5,}  of  {:>5,}.'.format(step, len(train_dataloader)))

        # push the batch to gpu
        batch = [r.to(device) for r in batch]

        sent_id, mask, labels = batch

        # clear previously calculated gradients
        model.zero_grad()

        # get model predictions for the current batch
        preds = model(sent_id, mask)

        # compute the loss between actual and predicted values
        loss = cross_entropy(preds, labels)

        # add on to the total loss
        total_loss = total_loss + loss.item()

        # backward pass to calculate the gradients
        loss.backward()

        # clip the the gradients to 1.0. It helps in preventing the exploding gradient problem
        torch.nn.utils.clip_grad_norm_(model.parameters(), 1.0)

        # update parameters
        optimizer.step()

        # model predictions are stored on GPU. So, push it to CPU
        preds = preds.detach().cpu().numpy()

        # append the model predictions
        total_preds.append(preds)

    # compute the training loss of the epoch
    avg_loss = total_loss / len(train_dataloader)

    # reshape the predictions in form of (number of samples, no. of classes)
    total_preds = np.concatenate(total_preds, axis=0)

    # returns the loss and predictions
    return avg_loss, total_preds

def bert_feature_extractor(my_dataloader):

    print("\nEvaluating..")

    # deactivate dropout layers
    model.eval()

    total_loss, total_accuracy = 0, 0

    # empty list to save the model predictions
    total_preds = []
    all_labels = []
    # iterate over batches
    for step, batch in enumerate(my_dataloader):

        # Progress update every 50 batches.
        #if step % 50 == 0 and not step == 0:

            # Calculate elapsed time in minutes.
            # elapsed = format_time(time.time() - t0)

            # Report progress.
            #print('  Batch {:>5,}  of  {:>5,}.'.format(
             #   step, len(my_dataloader)))

        # push the batch to gpu
        batch = [t.to(device) for t in batch]

        sent_id, mask, labels = batch

        # deactivate autograd
        with torch.no_grad():

            # model predictions
            preds = model.bert(sent_id, mask)[1]  # calling to the model

            # compute the validation loss between actual and predicted values

            preds = preds.detach().cpu().numpy()
            #print('preds.shape=',preds.shape)
            total_preds.append(preds)

            label = labels.detach().cpu().numpy()
            #print('labels',label[0])
            all_labels.append(label)
    # compute the validation loss of the epoch
    
    # reshape the predictions in form of (number of samples, no. of classes)
    total_preds = np.concatenate(total_preds, axis=0)
    all_labels = np.concatenate(all_labels, axis=0)
    print('Shape==',total_preds.shape) 
    return total_preds, all_labels

def format_time(time=None, format=None, rebase=True):
    """See :meth:`I18n.format_time`."""
    return get_i18n().format_time(time, format, rebase)

# evaluate the model
def evaluate():

    print("\nEvaluating..")

    # deactivate dropout layers
    model.eval()

    total_loss, total_accuracy = 0, 0

    # empty list to save the model predictions
    total_preds = []

    # iterate over batches
    for step, batch in enumerate(val_dataloader):

        # Progress update every 50 batches.
        if step % 50 == 0 and not step == 0:

            # Calculate elapsed time in minutes.
            # elapsed = format_time(time.time() - t0)

            # Report progress.
            print('  Batch {:>5,}  of  {:>5,}.'.format(
                step, len(val_dataloader)))

        # push the batch to gpu
        batch = [t.to(device) for t in batch]

        sent_id, mask, labels = batch

        # deactivate autograd
        with torch.no_grad():

            # model predictions
            preds = model(sent_id, mask)

            # compute the validation loss between actual and predicted values
            loss = cross_entropy(preds, labels)

            total_loss = total_loss + loss.item()

            preds = preds.detach().cpu().numpy()

            total_preds.append(preds)

    # compute the validation loss of the epoch
    avg_loss = total_loss / len(val_dataloader)

    # reshape the predictions in form of (number of samples, no. of classes)
    total_preds = np.concatenate(total_preds, axis=0)

    return avg_loss, total_preds

def get_evaluation_scores(tn, fp, fn, tp):
    print("get_score method is defined")
    if(tp == 0):
        accuracy = (tp+tn)/(tn+fp+fn+tp)
        Precision = 0
        Recall = 0
        F1 = 0
    else:
        accuracy = (tp+tn)/(tn+fp+fn+tp)
        Precision = tp/(tp+fp)
        Recall = tp/(tp+fn)
        F1 = 2*((Precision*Recall)/(Precision+Recall))
    return accuracy, F1, Precision, Recall

# give test data to the model in chunks to avoid Cuda out of memory error
def give_test_data_in_chunks(x_test):
    n = len(x_test) / 50 
    preds_chunks = None
    for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
        tokens_test = tokenizer.batch_encode_plus(
            x_test_chunk.tolist(), max_length=500, pad_to_max_length=True, truncation=True)
        test_seq = torch.tensor(tokens_test['input_ids'])
        test_mask = torch.tensor(tokens_test['attention_mask'])
        preds_chunk = model(test_seq.to(device), test_mask.to(device))
        preds_chunk = preds_chunk.detach().cpu().numpy()
        preds_chunks = preds_chunk if preds_chunks is None else np.append(
            preds_chunks, preds_chunk, axis=0)
        preds = np.argmax(preds_chunks, axis=1)

    return preds

execution_time = time.time()
print("Start time of the experiment", execution_time)
no_split=10
skf = StratifiedKFold(n_splits=no_split,shuffle=False)
TN = FP = FN = TP = 0
fold_number = 0
Total_auc = 0
total_execution_time = 0
total_execution_time_for_feature_extraction = 0
print('**************SHAPE INPUT DATA')

for fold in range(no_split):
    print(" NOW IN FOLD NUMBER", fold_number)
    #print(test_index)

    #X_train, X_test = input_data.iloc[list(train_index)], input_data.iloc[list(test_index)]
    #y_train, y_test = target_data.iloc[list(train_index)], target_data.iloc[list(test_index)]
    
    X_test=np.load(data_name+'/data_splits/X_test_fold'+str(fold)+'.npy',allow_pickle=True)
    y_test=np.load(data_name+'/data_splits/y_test_fold'+str(fold)+'.npy',allow_pickle=True)

    X_train=np.load(data_name+'/data_splits/X_train_fold'+str(fold)+'.npy',allow_pickle=True)
    y_train=np.load(data_name+'/data_splits/y_train_fold'+str(fold)+'.npy',allow_pickle=True)

    X_valid=np.load(data_name+'/data_splits/X_valid_fold'+str(fold)+'.npy',allow_pickle=True)
    y_valid=np.load(data_name+'/data_splits/y_valid_fold'+str(fold)+'.npy',allow_pickle=True)
   
    #X_train, X_valid, y_train, y_valid=train_test_split(X_train, y_train, random_state=49, test_size=0.2, stratify=y_train)
    print(len(X_train))
    X_train, y_train, X_valid, y_valid = sampling(X_train, y_train, X_valid, y_valid)

    tokens_train, tokens_val, tokens_test = tokenize_data(
        X_train, X_valid, X_test)
    Y_train = pd.DataFrame(y_train)
    y_val = pd.DataFrame(y_valid)
    y_test = pd.DataFrame(y_test)
    print('HI*******')
    #print(tokens_train)
    print('Hello**************')
    Y_train.columns = ['which_tests']
    y_val.columns = ['which_tests']
    y_test.columns = ['which_tests']

    # convert labels of train, validation and test into tensors
    train_y = torch.tensor(Y_train['which_tests'].values)
    val_y = torch.tensor(y_val['which_tests'].values)
    test_y = torch.tensor(y_test['which_tests'].values)

    train_seq, train_mask, val_seq, val_mask, test_seq, test_mask = text_to_tensors(tokens_train, tokens_val, tokens_test)

    # create data_loaders for train and validation dataset
    train_dataloader, val_dataloader, test_dataloader = data_loaders(train_seq, train_mask, train_y, val_seq, val_mask, val_y, test_seq, test_mask, test_y)

    # compute the class weights
    class_weights = compute_class_weight('balanced', np.unique(Y_train.values), y=np.ravel(Y_train.values))
    # convert list of class weights to a tensor
    weights = torch.tensor(class_weights, dtype=torch.float)

    # push to GPU
    weights = weights.to(device)

    # define the loss function
    cross_entropy = nn.NLLLoss(weight=weights)

    # number of training epochs
    epochs = 20

    print("Class Weights:", class_weights)

    model = BERT_Arch(auto_model)

    # push the model to GPU
    model = model.to(device)

    # define the optimizer
    optimizer = AdamW(model.parameters(), lr=1e-5)

    gc.collect()
    torch.cuda.empty_cache()
    # set initial loss to infinite
    best_valid_loss = float('inf')

    # empty lists to store training and validation loss of each epoch
    train_losses = []
    valid_losses = []

    # load weights of best model
    model.load_state_dict(torch.load(model_weights_path+str(fold_number)+'.pt'))
    x_train_bert, y_train_label = bert_feature_extractor(train_dataloader)
    x_val_bert, y_val_label = bert_feature_extractor(val_dataloader)
    
    start_time_for_feature_extraction = time.time()
    x_test_bert, y_test_label = bert_feature_extractor(test_dataloader)
    total_execution_time_for_feature_extraction+=(time.time() - start_time_for_feature_extraction)
    
    if ml_technique == "RF":
        model_ml = RandomForestClassifier(n_estimators=5000, verbose=1, class_weight="balanced" )
    
    elif ml_technique == "SVC":
        model_ml = svm.SVC(C=1, kernel='linear', gamma='scale')

    elif ml_technique == "XGB":
        model_ml = XGBClassifier()
    
    elif ml_technique == "GBM":
        model_ml = GradientBoostingClassifier(n_estimators=1000, learning_rate=0.1, max_depth=1, random_state=0)
   
    elif ml_technique == "DT":
        model_ml = DecisionTreeClassifier(criterion='entropy', max_depth = None) 
    
    elif ml_technique == "MLP":
        model_ml = MLPClassifier(hidden_layer_sizes=(13,13,13),max_iter=50) 

    elif ml_technique == "Ada":
        model_ml = AdaBoostClassifier(n_estimators=100, random_state=0) 
    
    elif ml_technique == "NB":
        model_ml = GaussianNB() 
    
    elif (ml_technique == 'KNN'):
        model_ml = KNeighborsClassifier(n_neighbors=7)
   
    elif (ml_technique == 'LR'):
        model_ml = LogisticRegression(random_state=0,solver='liblinear')

    elif (ml_technique == 'LDA'):
        model_ml = LinearDiscriminantAnalysis()

    trained_model = model_ml.fit(x_train_bert, y_train_label)
    start_time = time.time()
    predicted_labels = trained_model.predict(x_test_bert)
    total_execution_time+=(time.time() - start_time)
    #print(classification_report(y_test_label, predicted_labels))
    
    cr=classification_report(test_y, predicted_labels)
    print(type(cr))
    with open(where_data_comes+"-result/classification_report_"+str(no_split)+"folds_"+str(epochs)+"_epoch.txt", "a") as file:
        file.write(ml_technique+",Fold="+str(fold_number)+"\n")
        file.write(cr)
        file.write("\n")

    cm = confusion_matrix(test_y, predicted_labels)
    #print(cm)
	
    with open(where_data_comes+"-result/confusion_matrix_"+str(no_split)+"folds_"+str(epochs)+"_epoch.txt", "a") as file:
        file.write(ml_technique+",Fold="+str(fold_number)+"\n")
        file.write(np.array2string(cm))
        file.write("\n")

    tn, fp, fn, tp = confusion_matrix(y_test_label, predicted_labels, labels=[0, 1]).ravel()
    TN = TN + tn
    FP = FP + fp
    FN = FN + fn
    TP = TP + tp
    
    fpr, tpr, thresholds = metrics.roc_curve(y_test_label, predicted_labels, pos_label=1)
    Total_auc += metrics.auc(fpr, tpr)

    del model
    torch.cuda.empty_cache()

    fold_number = fold_number+1

avg_auc=Total_auc/no_split

accuracy, F1, Precision, Recall = get_evaluation_scores(TN, FP, FN, TP)

result = pd.DataFrame(columns = ['Classifier','Accuracy','F1', 'Precision', 'Recall', 'TN', 'FP', 'FN', 'TP','Total_execution_time(Sec)','Feature_extraction_time(Sec)','AUC'])
result = result.append(pd.Series([ml_technique ,accuracy, F1, Precision, Recall, TN, FP, FN, TP, total_execution_time/no_split,total_execution_time_for_feature_extraction/no_split,avg_auc], index=result.columns), ignore_index=True)
result.to_csv(results_file,  index=False)

print("The processed is completed in : (%s) seconds. " % round((time.time() - execution_time), 5))






