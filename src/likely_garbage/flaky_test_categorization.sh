dataset_name=$(echo $1 | cut -d'_' -f1)
data_path="../dataset"
#results_path="../flaky-test-categorization/adversarial_training"
results_path="../flaky-test-categorization"
if [[ $1 == "IDoFT_2Cat" ]]; then #because the IDOFT_dataset.csv only contains tests which are flaky
    dataset_file="${data_path}/${dataset_name}/Flakify_${dataset_name}_dataset.csv" 
elif [[ $1 == "MARTIN_DATA_6Cat" ]]; then
    dataset_file="${data_path}/${dataset_name}/NOD_Test_From_ICSE_MARTIN_DATA" 
else
    dataset_file="${data_path}/${dataset_name}/${dataset_name}_dataset_with_nonflaky_indented.csv"  
    #dataset_file="${data_path}/Java-WebSocket_test_methods.csv" 
    #dataset_file="${data_path}/simple-maven-project-with-tests_test_methods.csv"  
    #dataset_file="${data_path}/Accenture_test_methods.csv"
    #dataset_file="${data_path}/assignment1_test_methods.csv"
    echo "$dataset_file" 
    #exit
fi
model_weights="${results_path}/model_weights_on_${1}_dataset" # This one is needed to save the best model
results_file="${results_path}/sklearn_predictor/results_on_${1}_dataset"
#processed_data_with_vocab_file=base_path+"/data/processed_data_with_vocabulary_per_test.csv"

if [[ ! -d "${results_path}/sklearn_predictor" ]]; then
    mkdir -p "${results_path}/sklearn_predictor"
fi
#Flakify_cross_validation_results_on_IDoFT_dataset_Flakify.csv
if [[ $2 == "train" ]]; then
   if [[ $1 == "Flakicat" ]]; then 
        if [[ $3 == "Flakify-Org" ]]; then
            python Bert_train_flakify_original_categorization.py $dataset_file $model_weights "${results_file}_FlakiCat_BERT.csv"  "Flakicat_Categorization-Data" "BERT-Flakicat"
        else
           python3 Bert_train_categorization.py $dataset_file "$model_weights" "${results_file}_FlakiCat_BERT.csv"  "Flakicat_Categorization-Data" "BERT-Flakicat"
        fi
   elif [[ $1 == "IDoFT_6Cat" ]]; then # This one will be for 6 category
        if [[ $3 == "Flakify-Org" ]]; then
            python Bert_train_flakify_original_categorization.py $dataset_file $model_weights "${results_file}_BERT.csv" "IDOFT_6Category-Data" "BERT-$1"
        else
            python3 Bert_train_categorization.py $dataset_file $model_weights "${results_file}_BERT.csv" "IDOFT_6Category-Data" "BERT-$1"
        fi
   else #IDFT_2Cat
       #else
           python3 Bert_train_categorization.py $dataset_file $model_weights "${results_file}_BERT.csv" "IDOFT_2Category-Data" "BERT-$1"
       #fi
   fi

elif [[ $2 == "explain" ]]; then
    if [[ $1 == "Flakicat" ]]; then
        python3 explainable.py $dataset_file $model_weights "${results_file}_explain.csv" "Flakicat_Categorization-Data" "BERT-Flakicat"
    fi
else # $2=test
    if [[ $1 == "Flakicat" ]]; then 
        if [[ $3 == "Flakify-Org" ]]; then
            python Testing_original_flakify.py $dataset_file $model_weights "${results_file}_$2.csv" "$2-Flakicat" "Flakicat_Categorization-Data"
        elif [[ $2 == "codet5" ]]; then 
                python3 Testing_codet5_flaky_categorization.py $dataset_file $model_weights "${results_file}_codeT5.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "t5_small" ]]; then 
                python3 Testing_t5_categorization.py $dataset_file $model_weights "${results_file}_T5_small.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "codellama_7b_instruct" ]]; then
                python3 Testing_codellama7b_instruct_categorization.py $dataset_file $model_weights "${results_file}_codellama7b_instruct.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "llama_7b" ]]; then
                python3 Testing_llama7b_categorization.py $dataset_file $model_weights "${results_file}_llama7b.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "llama_3_8b" ]]; then
                python3 Testing_llama3_8b_categorization.py $dataset_file $model_weights "${results_file}_llama8b.csv" "Flakicat_Categorization-Data" "$2-$1" 
        elif [[ $2 == "llama_3_70b" ]]; then
                python3 Testing_llama3_70b_categorization.py $dataset_file $model_weights "${results_file}_llama70b.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "qwen" ]]; then
                python3 Testing_qwen_categorization.py $dataset_file $model_weights "${results_file}_qwen.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "codegemma" ]]; then
                python3 Testing_codegemma_7b_categorization.py $dataset_file $model_weights "${results_file}_codegemma.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "deep_seek_coder" ]]; then
                echo "DEEP SEEK CODER" 
                python3 Testing_deep_seek_coder_categorization.py $dataset_file $model_weights "${results_file}_deep_seek_coder.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "gemma_2b" ]]; then
                python3 Testing_gemma_2b_categorization.py $dataset_file $model_weights "${results_file}_gemma2b.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "gemma_7b" ]]; then
                python3 Testing_gemma_7b_categorization.py $dataset_file $model_weights "${results_file}_gemma7b.csv" "Flakicat_Categorization-Data" "$2-$1"
        elif [[ $2 == "BERT" ]]; then
            echo "calling to Testing_bert_flaky_categorization.py"
            python3 Testing_bert_flaky_categorization_for_any_new_proj.py $dataset_file $model_weights "${results_file}_$2.csv" "Flakicat_Categorization-Data" "$2-Flakicat"  # $5 needed to load data
           fi
    elif [[ $2 == "traditional_ml" ]]; then
        echo "Traditional ml"
        if [[ $1 == "IDoFT_6Cat" ]]; then
            python3 Testing_bert_flaky_categorization.py $dataset_file $model_weights "${results_file}_$3.csv" "$3-$1" "IDOFT_6Category-Data"  # $5 needed to load data
        elif [[ $1 == "IDoFT_2Cat" ]]; then
            python3 Testing_bert_flaky_categorization.py $dataset_file $model_weights "${results_file}_$3.csv" "$3-$1" "IDOFT_2Category-Data"  # $5 needed to load data
        fi
    else # inference, $2="BERT"
        if [[ $1 == "IDoFT_6Cat" ]]; then
            if [[ $3 == "Flakify-Org" ]]; then 
                python Testing_original_flakify.py $dataset_file $model_weights "${results_file}_$2_inference.csv" "$2-$1" "IDOFT_6Category-Data"
            else
                python3 Testing_bert_flaky_categorization.py $dataset_file $model_weights "${results_file}_$2.csv" "$2-$1" "IDOFT_6Category-Data"
            fi
        elif [[ $1 == "IDoFT_2Cat" ]]; then
            if [[ $2 == "t5_small" ]]; then 
                python3 Testing_t5_categorization.py $dataset_file $model_weights "${results_file}_T5_small.csv" "IDOFT_2Category-Data" "$2-$1"
            elif [[ $2 == "BERT" ]]; then
                python3 Testing_bert_flaky_categorization.py $dataset_file $model_weights "${results_file}_$2.csv"  "IDOFT_2Category-Data" "$2-$1" 
            fi
        
        elif [[ $1 == "MARTIN_DATA_6Cat" ]]; then
            python3 Testing_bert_flaky_categorization_to_run_Martin_dataset.py $dataset_file $model_weights "${results_file}_$2.csv" "$2-$1" "MARTIN_6Category-Data"
	    fi
    fi
fi
