#!/bin/bash
bash per_project_prediction.sh Flakicat "train"
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

