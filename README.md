# Understanding_and_Improving_FlakyTest_Classifiers_Artifact

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

To run the prediction code, run the following command.

```shell
bash per_project_prediction.sh FlakyLens "BERT"
```

If you want to get the attribution score for the tokens, run the following command
```shell
bash per_project_prediction.sh FlakyLens "BERT" "calculate_gradient"
```
This outputs the attribution scores in Attributions_scores directory.
/FlakyLens_attributions_project_group_1.csv
