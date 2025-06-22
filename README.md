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
bash per_project_prediction.sh Flakicat "train"
```

To run the prediction code, run the following command.

```shell
bash per_project_prediction.sh Flakicat "BERT"
```
