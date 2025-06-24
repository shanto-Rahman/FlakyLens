# Understanding_and_Improving_FlakyTest_Classifiers_Artifact

# Dataset

Our dataset is available in ```dataset/FlakyLens/FlakyLens_dataset_with_nonflaky_indented.csv```

# Environment
```shell
conda create -n flakylense python=3.8.5
pip install -r requirements.txt
```

```shell
cd src
```

To run the training code, run the following command.

```shell
bash per_project_prediction.sh FlakyLens "train"
```

This train code will save the model into the following directory ../flaky-test-categorization_per_project/

To run the prediction code, run the following command. This may take around 2-3 mins.

```shell
bash per_project_prediction.sh FlakyLens "BERT"
```

If you want to get the attribution score for the tokens, run the following command
```shell
bash per_project_prediction.sh FlakyLens "BERT" "calculate_gradient"
```

Now to parse the result, run the following command from flaky-test-categorization/scripts
```shell
 bash per_category_parse_result.sh ../per_Category_Evaluation_BERT-FlakyLens.txt
 ```


This outputs the attribution scores in Attributions_scores directory.
/FlakyLens_attributions_project_group_1.csv
