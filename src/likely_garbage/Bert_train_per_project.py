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
from codebert_model import BERT_Arch
from early_stopping import EarlyStopping
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, codebert_model_define
import seaborn as sns
import matplotlib.pyplot as plt
import random
import math
from torch.utils.tensorboard import SummaryWriter
from data_processing import sampling, Tokenizer, TensorConverter, DataLoaderFactory, create_tensor_and_data_loader
from sklearn.metrics import f1_score
import inspect
from imblearn.over_sampling import SMOTE
from imblearn.combine import SMOTEENN
from imblearn.over_sampling import BorderlineSMOTE
import torch.nn.functional as F
from sklearn.utils import resample
from Testing_per_project import boosting_noisy_data_for_train

import torch
import torch.nn as nn
import torch.nn.functional as F
import numpy as np

class ClassBalancedLoss(nn.Module):
    def __init__(self, beta, samples_per_cls, num_classes, loss_type="softmax"):
        super(ClassBalancedLoss, self).__init__()
        self.beta = beta
        self.samples_per_cls = samples_per_cls
        self.num_classes = num_classes
        self.loss_type = loss_type

        effective_num = 1.0 - np.power(beta, samples_per_cls)
        weights = (1.0 - beta) / np.array(effective_num)
        weights = weights / np.sum(weights) * num_classes
        self.class_weights = torch.tensor(weights, dtype=torch.float)

    def forward(self, logits, labels):
        labels_one_hot = F.one_hot(labels, self.num_classes).float().to(logits.device)
        weights = self.class_weights.to(logits.device)
        weights = weights.unsqueeze(0) * labels_one_hot
        weights = weights.sum(1).unsqueeze(1)

        if self.loss_type == "softmax":
            pred = F.log_softmax(logits, dim=1)
            cb_loss = -weights * pred
            cb_loss = cb_loss.sum(dim=1)
        elif self.loss_type == "sigmoid":
            pred = torch.sigmoid(logits)
            cb_loss = F.binary_cross_entropy(pred, labels_one_hot, weight=weights, reduction='none')
            cb_loss = cb_loss.sum(dim=1)
        else:
            raise ValueError("Unsupported loss_type. Choose 'softmax' or 'sigmoid'.")

        return cb_loss.mean()

class LDAMLoss(nn.Module):
    def __init__(self, cls_num_list, max_m=0.5, weight=None, s=30):
        super(LDAMLoss, self).__init__()
        m_list = 1.0 / np.sqrt(np.sqrt(cls_num_list))
        m_list = m_list * (max_m / np.max(m_list))
        self.m_list = torch.tensor(m_list, dtype=torch.float32)
        self.weight = weight
        self.s = s

    def forward(self, x, target):
        index = torch.zeros_like(x, dtype=torch.uint8)
        index.scatter_(1, target.data.view(-1, 1), 1)
        index_float = index.type(torch.FloatTensor).to(x.device)

        batch_m = torch.matmul(self.m_list[None, :].to(x.device), index_float.transpose(0, 1)).view((-1, 1))
        x_m = x - index_float * batch_m

        output = torch.where(index, x_m, x)
        return F.cross_entropy(self.s * output, target, weight=self.weight)


class DiceLoss(nn.Module):
    def __init__(self, smooth=1e-6):
        super(DiceLoss, self).__init__()
        self.smooth = smooth

    def forward(self, logits, targets):
        """
        logits: [batch_size, num_classes]
        targets: [batch_size] (class indices)
        """
        # Convert targets to one-hot
        num_classes = logits.shape[1]
        targets_one_hot = F.one_hot(targets, num_classes=num_classes).float()

        # Apply softmax to get class probabilities
        probs = F.softmax(logits, dim=1)

        # Compute Dice Loss
        intersection = torch.sum(probs * targets_one_hot, dim=0)
        union = torch.sum(probs + targets_one_hot, dim=0)
        dice = (2. * intersection + self.smooth) / (union + self.smooth)
        dice_loss = 1 - dice.mean()

        return dice_loss

# Step 2: Define Focal Loss
class FocalLoss(nn.Module):
    def __init__(self, alpha=None, gamma=2.0, reduction='mean'):
        super(FocalLoss, self).__init__()
        self.alpha = alpha
        self.gamma = gamma
        self.reduction = reduction

    def forward(self, logits, targets):
        ce_loss = F.cross_entropy(logits, targets, reduction='none', weight=self.alpha)
        pt = torch.exp(-ce_loss)  # Probability of correct classification
        focal_loss = (1 - pt) ** self.gamma * ce_loss

        if self.reduction == 'mean':
            return focal_loss.mean()
        elif self.reduction == 'sum':
            return focal_loss.sum()
        else:
            return focal_loss

def calculate_filtered_avg(arr, th=-1000):
    filtered_arr = [x for x in arr  if x != th]
    avg = sum(filtered_arr) / len(filtered_arr)
    return avg

# balance dataset
def sampling(X_train, y_train, X_valid, y_valid):
    
    oversampling = RandomOverSampler(
        sampling_strategy='minority', random_state=49)
    x_train = X_train.values.reshape(-1, 1)
    y_train = y_train.values.reshape(-1, 1)
    x_val = X_valid.values.reshape(-1, 1)
    y_val = y_valid.values.reshape(-1, 1)
    
    x_train, y_train = oversampling.fit_resample(x_train, y_train)
    x_val, y_val = oversampling.fit_resample(x_val, y_val)
    x_train = pd.Series(x_train.ravel())
    y_train = pd.Series(y_train.ravel())
    x_val = pd.Series(x_val.ravel())
    y_val = pd.Series(y_val.ravel())

    return x_train, y_train, x_val, y_val

def compute_metrics(test_y,preds): 
    total_tp=0
    total_fp=0
    total_fn=0
    total_tn=0
    accuracies=[]
    f_scores=[]
    precisions=[]
    recalls=[]
    print(test_y)
    print(preds)
    for category in range(4):
        y=np.where(test_y==category,1,0) #taking y only for the specific category
        print(y)
        #print(test_y)
        p=np.where(preds==category,1,0)
        print("P====:w,"+str(category))
        print(p)
        n_p=np.sum(y==1) #positive
        n_n=np.sum(y==0) #negative
        '''if (n_p == 0):
            recalls.append(-1000)
            precisions.append(-1000)
            f_scores.append(-1000)
            continue'''
        
        cm = confusion_matrix(y, p, labels=[0, 1])
        tn, fp, fn, tp = cm.ravel()
        print(cm.ravel())
        if (tp == 0.0):
            precision=0.0
            recall=0.0
            f_score=0.0
        else:
            precision=tp/(tp+fp)
            recall=tp/(tp+fn)
            f_score=2*(precision*recall)/(precision+recall)
        recalls.append(recall)
        precisions.append(precision)
        f_scores.append(f_score)
        total_tp +=tp
        total_tn +=tn
        total_fp +=fp
        total_fn +=fn

    accuracy=(total_tp+total_tn)/len(test_y)
    return total_tp, total_tn, total_fp, total_fn, precisions, recalls, f_scores, accuracy


# setting the seed for reproducibility
def set_deterministic(seed):
    np.random.seed(seed)
    torch.manual_seed(seed)                    
    torch.cuda.manual_seed(seed)               
    torch.cuda.manual_seed_all(seed)           
    torch.backends.cudnn.deterministic = True 

# specify GPU
device = torch.device("cuda")

#reading the parameters 

dataset_path = sys.argv[1]
model_weights_path = sys.argv[2]
results_file = sys.argv[3]
dataset_type = sys.argv[4] # IDoFT_2Cat/ IDoFT_6Cat

df = pd.read_csv(dataset_path)
df.head()
# get project names
# balance dataset
def sampling(X_train, y_train, X_valid, y_valid):
    
    oversampling = RandomOverSampler(
        sampling_strategy='minority', random_state=49)
    x_train = X_train.values.reshape(-1, 1)
    y_train = y_train.values.reshape(-1, 1)
    x_val = X_valid.values.reshape(-1, 1)
    y_val = y_valid.values.reshape(-1, 1)
    
    x_train, y_train = oversampling.fit_resample(x_train, y_train)
    x_val, y_val = oversampling.fit_resample(x_val, y_val)
    x_train = pd.Series(x_train.ravel())
    y_train = pd.Series(y_train.ravel())
    x_val = pd.Series(x_val.ravel())
    y_val = pd.Series(y_val.ravel())

    return x_train, y_train, x_val, y_val


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
        train_f1 = f1_score(train_labels, train_preds_class, average='macro')  # Weighted F1-score for imbalanced data
        valid_f1 = f1_score(val_labels, val_preds_class, average='macro')  # Weighted F1-score for validation

        ## Log F1-score to TensorBoard
        #writer.add_scalar(f'F1_Score/train_fold_{fold_number}', train_f1, epoch)
        #writer.add_scalar(f'F1_Score/valid_fold_{fold_number}', valid_f1, epoch)

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
        writer.add_scalars(f'Macro_F1_Score/fold_{fold_number}', {
            'train': train_f1,
            'valid': valid_f1
        }, epoch)  

        # EarlyStopping needs to check if validation loss has improved
        early_stopping(valid_f1, model)
        if early_stopping.early_stop:
            print("Early stopping")
            break
    
        print("Forward method signature:", inspect.signature(model.forward))
        #if valid_loss < best_valid_loss:
        if valid_f1 > best_f1_score:
            #best_valid_loss = valid_loss
            best_f1_score = valid_f1
            #torch.save(model.state_dict(), model_weights_path+str(fold_number)+'_adversarial_training.pt')
            torch.save(model.state_dict(), model_weights_path+'_project_group_'+str(fold_number)+'.pt')
            print('Saving the model ****')
            #torch.save(model.state_dict(), model_weights_path+str(fold_number)+'_With_noisy_train_data.pt')
            #torch.save(model.state_dict(), model_weights_path+str(fold_number)+'.pt')
    
        train_losses.append(train_loss)
        valid_losses.append(valid_loss)
    
        print(f'\nTraining Loss: {train_loss:.3f}, accuracy: {train_acc}, f1: {train_f1}')
        print(f'Validation Loss: {valid_loss:.3f}, accuracy: {valid_acc}, f1: {valid_f1}')

    return model_weights_path

def downsample_category5(df, category_col, max_size=2000):
    """ 
    Downsamples category 5 to a specified max size while keeping other categories unchanged.
    """
    category_5_df = df[df[category_col] == 5].copy()  # Ensure a fresh copy
    
    print("📌 Before Resampling:", len(category_5_df))  # Debugging

    if len(category_5_df) > max_size:
        category_5_df = resample(category_5_df, replace=True, n_samples=max_size, random_state=42)

    print("📌 After Resampling:", len(category_5_df))  # Should print 2000

    # Keep other categories unchanged
    other_categories_df = df[df[category_col] != 5]

    # Merge back
    return pd.concat([other_categories_df, category_5_df])


def apply_smote(train_data_Org, train_y_Org):
    from imblearn.over_sampling import SMOTE
    from sklearn.feature_extraction.text import TfidfVectorizer

    # ✅ Step 1: Store Original Text Data
    train_x_Org = train_data_Org['full_code']  # Original text
    train_y_Org = train_data_Org['category']   # Original labels
    
    #valid_x = valid_data['full_code']
    #valid_y = valid_data['category']
    
    print('Before train data')
    print('train_data=')
    print(train_y_Org.value_counts())
    
    # ✅ Step 2: Convert text into numerical vectors (TF-IDF)
    vectorizer = TfidfVectorizer(max_features=5000)
    train_x_vec = vectorizer.fit_transform(train_x_Org)  # Convert text to numerical vectors
    
    # ✅ Step 3: Store original indices (needed to track resampled data)
    train_x_Org = train_x_Org.reset_index(drop=True)  # Ensure sequential indexing
    
    # ✅ Step 4: Apply SMOTE **on the numerical representation**
    smote = SMOTE(sampling_strategy={0: 500, 1: 500, 2: 500, 3: 500, 4: 500}, random_state=42)
    train_x_resampled, train_y_resampled = smote.fit_resample(train_x_vec, train_y_Org)

    '''borderline_smote = BorderlineSMOTE(sampling_strategy='auto', random_state=42, kind='borderline-1')
    train_x_resampled, train_y_resampled = borderline_smote.fit_resample(train_x_vec, train_y_Org)'''

    #smote_enn = SMOTEENN(sampling_strategy='auto', random_state=42)
    #train_x_resampled, train_y_resampled = smote_enn.fit_resample(train_x_vec, train_y_Org)

    
    # ✅ Step 5: Match resampled labels back to original text
    # We need to handle synthetic samples properly (since they're created by interpolation)
    #num_synthetic_samples = len(train_x_resampled) - len(train_x_Org)
    num_synthetic_samples = train_x_resampled.shape[0] - train_x_Org.shape[0]

    train_x_resampled_text = list(train_x_Org)  # Start with original texts
    
    # Extend text list for synthetic samples (use a placeholder if needed)
    train_x_resampled_text.extend(["[SMOTE-generated-sample]"] * num_synthetic_samples)
    
    # ✅ Step 6: Convert back to Pandas Series
    train_x = pd.Series(train_x_resampled_text, name="full_code")
    train_y = pd.Series(train_y_resampled, name="category")
    
    # ✅ Step 7: Final Resampled Train Data
    train_data = pd.DataFrame({"full_code": train_x, "category": train_y})
    
    # ✅ Check Final Data Types
    print(type(train_x))  # <class 'pandas.core.series.Series'>
    print(type(train_data))  # <class 'pandas.core.frame.DataFrame'>
    return train_x, train_data, train_y

def run_experiment(dataset_path, model_weights_path, results_file, data_name_dir, technique):
    df = pd.read_csv(dataset_path)  # Load the dataset

    #project_index=0
    x = 'full_code'
    y='category'
    project_group = 0
    output_layer = 6
    total_fine_tuning_time = 0
    
    #for i in sorted(project_name):
    # Without Adversarial train 
    train_files = sorted([f for f in os.listdir(data_name_dir+"/data_split") if f.startswith("train_") and f.endswith(".csv")])
    valid_files = sorted([f for f in os.listdir(data_name_dir+"/data_split") if f.startswith("valid_") and f.endswith(".csv")])
    #During adversarial
    '''train_files = sorted([f for f in os.listdir(data_name_dir+"/data_split/with_50_percent_noisy_data") if f.startswith("train_") and f.endswith("_with_noisy_data_excluding_nonflakyCat.csv")])
    valid_files = sorted([f for f in os.listdir(data_name_dir+"/data_split/with_50_percent_noisy_data") if f.startswith("valid_") and f.endswith("_with_noisy_data_excluding_nonflakyCat.csv")])'''
    test_files = sorted([f for f in os.listdir(data_name_dir) if f.startswith("test_") and f.endswith(".csv")])

    # Ensure each train file has a corresponding test file
    assert len(train_files) == len(test_files), "Mismatch between train and test files"

    #for train_file, test_file in zip(train_files, test_files):
    for train_file, test_file, valid_file in zip(train_files, test_files, valid_files): ##During adversarial training, also data preperation
        model_name, tokenizer, auto_model = codebert_model_define()
        #project_index +=1
        project_group +=1
        print("================")
        print('*** group:', str(project_group))
        # Read train and test data
        #train_dataset = pd.read_csv(os.path.join(data_name_dir, train_file))
        #Adversarial
        '''train_data_Org = pd.read_csv(os.path.join(data_name_dir+"/data_split/with_50_percent_noisy_data", train_file))
        valid_data = pd.read_csv(os.path.join(data_name_dir+"/data_split/with_50_percent_noisy_data", valid_file))'''

        train_data_Org = pd.read_csv(os.path.join(data_name_dir+"/data_split", train_file))
        valid_data = pd.read_csv(os.path.join(data_name_dir+"/data_split", valid_file))

        test_dataset = pd.read_csv(os.path.join(data_name_dir, test_file))
        #print("Len=", len(train_data_Org))
        #exit()
        #print('project_grpup=',len(train_dataset))
        #downsampled_train_df = downsample_category5(train_dataset, "category")
      
        #train_data_Org, valid_data = train_test_split(train_dataset, random_state=49, test_size=0.3, stratify=train_dataset[y])

        train_x_Org = train_data_Org['full_code']  # Keep all columns except 'category'
        train_y_Org = train_data_Org['category']  # Extract the target variable
        
        valid_x = valid_data['full_code']  # Keep all columns except 'category'
        valid_y = valid_data['category']  # Extract the target variable
        print('Before train data')
        print('train_data=')
        print(train_y_Org.value_counts())

        #Adversarial
        '''os.makedirs(f"{data_name_dir}/data_split/with_50_percent_noisy_data", exist_ok=True)
        boosting_noisy_data_for_train(train_x_Org, train_y_Org, project_group, "train")
        boosting_noisy_data_for_train(valid_x, valid_y, project_group, "valid")'''
        #exit()
        train_x, train_data, train_y = apply_smote(train_data_Org, train_y_Org) 

        ## Save train_data with all columns
        #train_data.to_csv(f"{data_name_dir}/data_split/train_set_{project_group}.csv", index=False)
        #valid_data.to_csv(f"{data_name_dir}/data_split/valid_set_{project_group}.csv", index=False)
        # Extract features (X) and target (Y) from the saved CSV files
        
        # Display the extracted datasets
        #print("train_x:")
        #print(train_x.head())
        #
        #print("\ntrain_y:")
        #print(train_y.head())
        #
        #print("\nvalid_x:")
        #print(valid_x.head())
        #exit()
        

        #train_x, valid_x, train_y, valid_y = train_test_split(train_dataset[x], train_dataset[y], random_state=49, test_size=0.2, stratify=train_dataset[y])
        #print("train_x=")
        #train_x.to_csv("tmp.txt", index=False)
        #print(train_x)
        #exit()
        test_x=test_dataset[x]
        test_y=test_dataset[y]
        print('valid_data=')
        print(valid_y.value_counts())
        print('train_data=')
        print(train_y.value_counts())
        print('test_data=')
        print(test_y.value_counts())
        # Count occurrences of each category in test_y
        label_counts = test_y.value_counts().sort_index()
        
        # Print the count of each label (0 to 5)
        for label in range(6):  # Assuming labels are 0, 1, 2, 3, 4, 5
            print(f"Label {label}: {label_counts.get(label, 0)}")

        #tokens_train, tokens_val, tokens_test = tokenize_data(train_x, valid_x, test_x)
        tokenizer_instance = Tokenizer(tokenizer)
        print(type(train_x))
        print(type(valid_x))
        tokens_val = tokenizer_instance.tokenize_validation_data(valid_x)
        tokens_train = tokenizer_instance.tokenize_training_data(train_x)
        tokens_test = tokenizer_instance.tokenize_test_data(test_x)
        #print('tokens_train:')
        #print(tokens_train)
        #exit()
        #exit()
    
        # converting labels of train, validation and test into tensors
    
        Y_train = pd.DataFrame(train_y)
        y_val = pd.DataFrame(valid_y)
        y_test = pd.DataFrame(test_y)
    
        Y_train.columns = ['category']
        y_val.columns = ['category']
        y_test.columns = ['category']
    
        # converting labels of train, validation and test into tensors
        train_y = torch.tensor(Y_train['category'].values)
        val_y = torch.tensor(y_val['category'].values)
        test_y = torch.tensor(y_test['category'].values)

        batch_size = 8  # Define the batch size
        train_dataloader, val_dataloader = create_tensor_and_data_loader(tokens_train, tokens_val, tokens_test, batch_size, seed_worker, train_y, val_y)  
    
         # compute the class weights
        #class_weights = compute_class_weight('balanced', classes = np.unique(Y_train.values), y=np.ravel(Y_train.values))
        #weights = torch.tensor(class_weights, dtype=torch.float)
        loss_fun_name = "CB"
        class_weights = compute_class_weight(class_weight='balanced', classes=np.unique(Y_train), y=Y_train.values.flatten())
        #weights = torch.tensor(np.log1p(class_weights), dtype=torch.float).to(device)  # Apply log scaling
        weights = torch.tensor(class_weights, dtype=torch.float).to(device)  # Apply log scaling
    
        # push to GPU
        weights = weights.to(device)
    
        # define the loss function
        #cross_entropy = nn.NLLLoss(weight=weights)
        #cross_entropy = nn.CrossEntropyLoss(weight=weights)
        #loss_fn 
        #cross_entropy = FocalLoss(alpha=weights.to(device), gamma=2.0)
        #cross_entropy = DiceLoss()
        # Compute number of samples per class
        if loss_fun_name == "LDAM":
            cls_sample_count = np.array([np.sum(Y_train['category'].values == t) for t in np.unique(Y_train)])
            # Convert class weights to torch tensor (if needed)
            weights = torch.tensor(class_weights, dtype=torch.float).to(device)
            # Define LDAMLoss with cls_num_list and weights
            cross_entropy = LDAMLoss(cls_num_list=cls_sample_count.tolist(), weight=weights).to(device)
        elif loss_fun_name == "CB":
            samples_per_cls = [sum(Y_train['category'] == i) for i in range(6)]
            cross_entropy = ClassBalancedLoss(beta=0.9999, samples_per_cls=samples_per_cls, num_classes=6, loss_type="softmax")



        #cross_entropy = loss_fn(outputs, labels)

    
        # number of training epochs
        epochs = 20
    
        print("Class Weights:", class_weights)
        print("Weights after applying log:", weights)
    
        model = BERT_Arch(auto_model, output_layer)
    
        # push the model to GPU
        model = model.to(device)
    
        # define the optimizer
        optimizer = AdamW(model.parameters(), lr=1e-5, weight_decay = 0.01)
    
        gc.collect()
        torch.cuda.empty_cache()
        # set initial loss to infinite
        best_valid_loss = float('inf')
        best_model = model 
        start_time = time.time()
        writer = SummaryWriter(log_dir=f"runs/experiment_{project_group}")
        model_weights_path = calculate_train_and_validation_loss(model_weights_path, project_group, model, train_dataloader, val_dataloader, cross_entropy, device, optimizer, epochs, writer)
        writer.close()
        total_fine_tuning_time+=(time.time() - start_time)

        # empty lists to store training and validation loss of each epoch
   
        del model
        torch.cuda.empty_cache()
    
        #result = result.append(pd.Series([project_Name,accuracy, F1, Precisions, Recalls, TN, FP, FN, TP, avg_precision,avg_recall,avg_f1, len(test_y)], index=result.columns), ignore_index=True)
    
        #result.to_csv(results_file,  index=False)

import pandas as pd
import random
import math

def create_train_test_groups(df, num_test_projects=25):
    unique_projects = df['project'].unique().tolist()  # Get list of unique project names
    random.shuffle(unique_projects)  # Shuffle projects for randomness
    num_groups = math.ceil(len(unique_projects) / num_test_projects)  # Number of groups

    train_test_groups = []
    used_projects = set()  # Track projects that have been used

    for i in range(num_groups - 1):  # Create the first 9 groups with 10 projects each
        available_projects = [p for p in unique_projects if p not in used_projects]

        # Select 10 projects for the test dataset
        test_projects = available_projects[:num_test_projects]

        # Create test dataset
        test_dataset = df[df['project'].isin(test_projects)]

        # Ensure all categories (0-5) are present in the test dataset
        while True:
            category_counts = test_dataset['category'].value_counts()
            missing_categories = [cat for cat in range(6) if category_counts.get(cat, 0) < 4]

            if not missing_categories:
                break  # All categories are present, exit loop
            else:
                random.shuffle(available_projects)  # Shuffle and try again
                test_projects = available_projects[:num_test_projects]
                test_dataset = df[df['project'].isin(test_projects)]  # Update test dataset

        # Update used projects
        used_projects.update(test_projects)

        # Create train dataset (all projects except test ones)
        train_dataset = df[~df['project'].isin(test_projects)]

        train_test_groups.append((train_dataset, test_dataset))

    # Last group with the remaining 8 projects (or fewer if there are fewer than 10 left)
    available_projects = [p for p in unique_projects if p not in used_projects]

    if available_projects:  # If there are any projects left
        test_projects = available_projects  # All remaining projects
        test_dataset = df[df['project'].isin(test_projects)]

        train_dataset = df[~df['project'].isin(test_projects)]

        train_test_groups.append((train_dataset, test_dataset))

    return train_test_groups

def build_dataset_group(dataset_path, data_name_dir):
    # Load dataset
    df = pd.read_csv(dataset_path)
    os.makedirs(data_name_dir, exist_ok=True) 
    # Create all possible train-test groups
    train_test_groups = create_train_test_groups(df)
    
    # Save each train-test set into separate CSVs
    for idx, (train_set, test_set) in enumerate(train_test_groups):
        unique_test_projects = test_set['project'].unique().tolist()  # Ensure uniqueness
        print(f"**Group {idx+1}:** {len(unique_test_projects)} projects")
        print(f"   Projects in Test Set: {unique_test_projects}\n")  # Use unique list

        #print(f"**Group {idx+1}:** {len(test_set['project'].unique())} projects")
        #print(f"   Projects in Test Set: {test_set['project'].tolist()}\n")

        test_set.to_csv(f"{data_name_dir}/test_set_{idx+1}.csv", index=False)
        train_set.to_csv(f"{data_name_dir}/train_set_{idx+1}.csv", index=False)
      
    
    print(f"Created {len(train_test_groups)} train-test groups. Each test set contains 6 projects, and each train set contains the remaining projects.")

if __name__ == "__main__":
    dataset_path = sys.argv[1]
    model_weights_path = sys.argv[2]
    results_file = sys.argv[3]
    data_name_dir = sys.argv[4]
    technique = sys.argv[5]
    #build_dataset_group(dataset_path, data_name_dir) # will call only the first time
    #initialize_environment(42)
    run_experiment(dataset_path, model_weights_path, results_file, data_name_dir, technique)
