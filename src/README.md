python3 compare_perturbation_result.py Flakicat_Categorization-result/without_perturbation.txt Flakicat_Categorization-result/deadcode_perturbation.txt
deadcode_perturbation

bash heatmap_category_wise_feature_attribution.sh

python3 gpt_experiment_to_get_pertubed_code.py attributions_deadcode_perturbation/ GPT_Results




Date: Mar. 3, 2025

Prediction of fine-tuned model. THis will also save the attribution score for each token of each test
bash per_project_prediction.sh Flakicat "BERT"

Now I need to look for the tokens for those tests that are correctly predicted
a) Here I first find the rows that have both True_class, and Predicted_Class same
b) Then for each test, multiply each attribution score, with the confidence score. And make a new column to update this score.
c) Then will make 6 groups for 6 category of tokens.
Aggregates attribution scores for each token (if a token appears multiple times, sum its scores).
Extracts the top 20 tokens based on aggregated attribution scores.
Ranks the 5 most frequent tokens from these top 100 tokens into the original data

Run the following command:
python3 find_top_k_tokens_from_each_category_by_finetuned_model.py

b) Consider top-20 tokens from each row, and their corresponding attribution score
d) Finally, for each category rank the tokens based on the highest weighted attribution scores, and collect the top 20 tokens.




