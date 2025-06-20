#!/bin/bash
#**********************************************************************************************
#**********************************************************************************************

##For 2nd Part (Categorization-6 category-[flaky categories]) -For Paper Table-II and Table-III (for multiple category)
#bash flaky_test_categorization.sh IDoFT_6Cat "train"  
#bash flaky_test_categorization.sh IDoFT_6Cat "BERT"  
#bash flaky_test_categorization.sh MARTIN_DATA_6Cat "BERT"  
#bash flaky_test_categorization.sh IDoFT_6Cat "traditional_ml" "KNN"
#bash flaky_test_categorization.sh IDoFT_6Cat "traditional_ml" "MLP"
#bash flaky_test_categorization.sh IDoFT_6Cat "traditional_ml" "RF"
#bash flaky_test_categorization.sh IDoFT_6Cat "traditional_ml" "SVC"
#bash flaky_test_categorization.sh IDoFT_6Cat "traditional_ml" "LR"
#
#bash flaky_test_categorization.sh IDoFT_2Cat "train"  
#bash flaky_test_categorization.sh IDoFT_2Cat "t5_small"
#bash flaky_test_categorization.sh IDoFT_2Cat "llama_7b"
###For 2nd Part (Categorization-2 category-[flaky,non-flaky]) -For Paper Table-II
#bash flaky_test_categorization.sh IDoFT_2Cat "BERT"  
#bash flaky_test_categorization.sh IDoFT_2Cat "traditional_ml" "KNN"
#bash flaky_test_categorization.sh IDoFT_2Cat "traditional_ml" "MLP"
#bash flaky_test_categorization.sh IDoFT_2Cat "traditional_ml" "RF"
#bash flaky_test_categorization.sh IDoFT_2Cat "traditional_ml" "SVC"
#bash flaky_test_categorization.sh IDoFT_2Cat "traditional_ml" "LR"
#
##For 2nd Part (Categorization-5 category-[from flakicat])  -For Paper Table-VII
#bash flaky_test_categorization.sh Flakicat "train" # on Flakicat data
#bash flaky_test_categorization.sh Flakicat "t5_small"
###bash flaky_test_categorization.sh Flakicat "llama_7b"
#bash flaky_test_categorization.sh Flakicat "llama_3_8b"
#bash flaky_test_categorization.sh Flakicat "deep_seek_coder"
#bash flaky_test_categorization.sh Flakicat "codellama_7b_instruct"
#bash flaky_test_categorization.sh Flakicat "codegemma"
#bash flaky_test_categorization.sh Flakicat "qwen"
#bash flaky_test_categorization.sh Flakicat "Mistral"
#bash flaky_test_categorization.sh Flakicat "gemma_2b"
#bash flaky_test_categorization.sh Flakicat "codet5"
#bash flaky_test_categorization.sh Flakicat "gemma_7b"
#bash flaky_test_categorization.sh Flakicat "BERT"
#bash flaky_test_categorization.sh Flakicat "KNN"
#bash flaky_test_categorization.sh Flakicat "MLP"
#bash flaky_test_categorization.sh Flakicat "RF"
#bash flaky_test_categorization.sh Flakicat "SVC"
#bash flaky_test_categorization.sh Flakicat "LR"
#bash flaky_test_categorization.sh Flakicat "test"
#
#bash flaky_test_categorization.sh Flakicat "explain" 
##
#bash per_project_prediction.sh Flakicat "train"
bash per_project_prediction.sh Flakicat "BERT"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode_perturbation"
#bash per_project_prediction.sh Flakicat "BERT" "printStatement_perturbation"
#bash per_project_prediction.sh Flakicat "BERT" "variableDeclare_perturbation"
#bash per_project_prediction.sh Flakicat "BERT" "multiLine_comment_perturbation"
#bash per_project_prediction.sh Flakicat "BERT" "singleLine_comment_perturbation"

#Perturbation in two
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-variableRenaming"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-multi_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-single_comment"

#bash per_project_prediction.sh Flakicat "BERT" "printStatement-variableRenaming"
#bash per_project_prediction.sh Flakicat "BERT" "printStatement-multi_comment"
#bash per_project_prediction.sh Flakicat "BERT" "printStatement-single_comment"

#bash per_project_prediction.sh Flakicat "BERT" "variableDeclare-multi_comment"
#bash per_project_prediction.sh Flakicat "BERT" "variableDeclare-single_comment"
#bash per_project_prediction.sh Flakicat "BERT" "multiLine_comment-singleLine_comment"

#Perturbation in three
#k=3
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-variableRenaming"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-multi_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-single_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-variableRenaming-multi_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-variableRenaming-single_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-multi_comment-single_comment"
#bash per_project_prediction.sh Flakicat "BERT" "printStatement-variableRenaming-multi_comment"
#bash per_project_prediction.sh Flakicat "BERT" "printStatement-variableRenaming-single_comment"
#bash per_project_prediction.sh Flakicat "BERT" "printStatement-multi_comment-single_comment"
#bash per_project_prediction.sh Flakicat "BERT" "variableRenaming-multi_comment-single_comment"

#k=4
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-variableRenaming-multi_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-variableRenaming-single_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-multi_comment-signle_comment"
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-multi_comment-single_comment"

#k=5
#bash per_project_prediction.sh Flakicat "BERT" "deadcode-printStatement-variableRenaming-multi_comment-single_comment"




#bash per_project_prediction.sh Flakicat "codellama"
#bash per_project_prediction.sh Flakicat "llama3_8b"
#bash per_project_prediction.sh Flakicat "qwen"
#bash per_project_prediction.sh Flakicat "gemma7b"
#bash per_project_prediction.sh Flakicat "gemma2b"
#bash per_project_prediction.sh Flakicat "codegemma"
#bash per_project_prediction.sh Flakicat "deep_seek_coder"

