#Flakify's flaky test prediction using cross-validation

data_path="../dataset"
results_path="../flaky-vs-nonflaky"
dataset_file="${data_path}/${1}/Flakify_$1_dataset.csv" 
model_weights="${results_path}/model_weights_on_${1}_dataset" #For saving the model.  Model takei weight bole. For each model, we will save one best model
results_file="${results_path}/sklearn_predictor/results_on_${1}_dataset" 

if [[ ! -d "${results_path}/sklearn_predictor" ]]; then
    mkdir -p "${results_path}/sklearn_predictor"
fi

if [[ $2 == "train" ]]; then
    if [[ $3 == "per-project-train" ]]; then
        results_file="${results_path}/sklearn_predictor/per_project_results_on_${1}_dataset" 
        if [[ $4 == "" ]]; then
            python3 -W ignore per_project_train_bert.py $dataset_file $model_weights "${results_file}.csv"
        else
            python3 -W ignore per_project_train_Tml.py $dataset_file $model_weights "${results_file}.csv" "$4" # Only for testing
        fi

    #elif [[ $3 == "traditional_ml" ]]; then
    #    python3 cross_validation_train_tml.py $dataset_file $model_weights "${results_file}_$2_$3.csv" "$3" "IDOFT_Flaky_vs_NonFlaky-Data"

    #else #cross fold
    #    python3 Bert_train.py $dataset_file $model_weights "${results_file}_withoutRandomOverSample_BERT.csv" "IDOFT_Flaky_vs_NonFlaky-Data"
    #fi

else # ONLY FOR BERT INFERENCE
    if [[ $2 == "test-per-project" ]]; then
        echo "I AM GOING TO TEST Per-Project flaky-vs-nonflaky detection"
        results_file="${results_path}/sklearn_predictor/per_project_results_on_${1}_dataset" 
        python3 -W ignore cross_validation_per_project_predictor_Tml.py $dataset_file $model_weights "${results_file}.csv" $3
    else
        echo "ONLY for bert inference ****"
        python3 Bert_inference_flaky_vs_non-flaky.py $dataset_file $model_weights "${results_file}_$2_withoutRandomOverSample_inference.csv" "IDOFT_Flaky_vs_NonFlaky-Data"
    fi
fi

