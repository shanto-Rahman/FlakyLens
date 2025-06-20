import time
import torch
from transformers import AutoTokenizer, AutoModelForCausalLM
from huggingface_hub import login
import sys
from utils import set_seed, setup_logging, seed_worker, train, evaluate, parse_cr, llama_7b_model_define
import pandas as pd
import os
import numpy as np

login(token="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")

timeStart = time.time()

#tokenizer = AutoTokenizer.from_pretrained(
#    "meta-llama/Llama-2-7b-chat-hf"
#)


#while(True):
#    input_str = input('Enter: ')
#    input_token_length = input('Enter length: ')
#
#    if(input_str == 'exit'):
#        break
#
#    timeStart = time.time()
#
#    inputs = tokenizer.encode(
#        input_str,
#        return_tensors="pt"
#    )
#
#    outputs = model.generate(
#        inputs,
#        max_new_tokens=int(input_token_length),
#    )
#
#    output_str = tokenizer.decode(outputs[0])
#
#    print(output_str)
#
#    print("Time taken: ", -timeStart + time.time())


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
    count = 0
    #attribution_csvfile_name = "attributions/"+dataset_category+"_attributions_category_"+str(label)+"_fold_"+str(fold)+".csv"
    #if os.path.exists(attribution_csvfile_name):
    #    os.remove(attribution_csvfile_name) 
    for index, row in x_test_df.iterrows():
        test_data = row['full_code']

        prompt = "What is the category of the given test? Is it Async wait or Concurrency or Time or Unordered collection or Order dependent test or non-flaky? \n" 
        input_str = prompt + test_data
        print(input_str)
        input_token_length = 512

        inputs = tokenizer.encode(input_str, return_tensors="pt")

        outputs = model.generate(
            inputs,
            max_new_tokens=int(input_token_length),
        )

        output_str = tokenizer.decode(outputs[0])

        print(output_str)
        exit()

    #for g, x_test_chunk in x_test.groupby(np.arange(len(x_test)) // n):
    #    count +=1
    #    # Ensure x_test_chunk is a DataFrame
    #    if isinstance(x_test_chunk, pd.Series):
    #        x_test_chunk = x_test_chunk.to_frame().T
    #    test_data = x_test_chunk.iloc[:, 0].tolist() if len(x_test_chunk) > 1 else [x_test_chunk.iloc[0, 0]]
    #    #test_y = Y_test['which_tests'].iloc[g]



    #    #tokens_test = tokenizer.batch_encode_plus(test_data, max_length=max_length, pad_to_max_length=True, truncation=True)
    #    #test_seq = torch.tensor(tokens_test['input_ids']).to(device)
    #    #test_mask = torch.tensor(tokens_test['attention_mask']).to(device)

    #    preds_chunk = model(test_seq, test_mask)
    #    preds_chunk = preds_chunk.detach().cpu().numpy()
    #    pred_class = np.argmax(preds_chunk, axis=1)
    #    pred_logit = preds_chunk[0, pred_class]
    #    total_preds.append(pred_class)

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
    device = torch.device("cuda")
    print(torch.cuda.is_available())  # This should return True if CUDA is available

    input_data, target_data, output_layer, dataset_category= preprocess_data(dataset_path, technique)
    where_data_comes = data_name.split("-")[0]

    model_name, tokenizer, auto_model = llama_7b_model_define()

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
        print(X_test.head(5))
        #print(test_y.head(5))

        model = auto_model
        
        # push the model to GPU
        #model = model.to(device)
    
        with torch.no_grad():
            preds = give_test_data_in_chunks(X_test, tokenizer, model, batch_size, device, fold)

    
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
