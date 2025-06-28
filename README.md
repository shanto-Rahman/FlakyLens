# Understanding_and_Improving_FlakyTest_Classifiers_Artifact

# Purpose
This README accompanies the artifact for the paper "Understanding and Improving Flaky Test Classification." This work introduces a new dataset that combines flaky and non-flaky tests, resulting in a more realistic distribution of test categories. The paper also presents a classification approach using fine-tuned models to predict the category of each test.

The primary goal of this artifact is to provide access to the dataset, training and inference code, and scripts for interpreting model predictions by identifying key features with attribution scores.

We are applying for the "Available" and "Reusable" badges. The dataset and code are publicly accessible via a Zenodo link, and all scripts are fully executable, enabling others to reproduce our results and extend the work.

# Provenance

The artifact can be obtained from https://zenodo.org/records/??? in the form of a Docker image. Note that the size of our Docker image including the dataset is about ???GB, so please prepare sufficient disk space.

# Requirements

docker

NVIDIA GPU

Disk Space ???GB


# Setup 
After downloading flakylens_latest.tar.gz from the Zenodo link, load it into Docker:

```shell
docker load < flakylens_latest.tar.gz
```

Ensure that your user is added to the docker group to interact with the Docker daemon without needing sudo. If you're not already a member of the docker group, please follow these instructions to run Docker commands as a non-root user: https://docs.docker.com/engine/install/linux-postinstall/.

To start a Docker container, use the following command:

```shell
docker run --gpus all -it --rm flakylens:latest
```

We evaluated our artifact on our end using Docker version 20.10.21, build 20.10.21-0ubuntu1~20.04.2.


# Usage
Use the following instructions to run through our artifact. Our models are placed into 
```
models/
```
For the prediction task, you need to run the following command

```shell
bash per_project_prediction.sh FlakyLens "BERT"
```
To run the prediction code, run the following command. This may take around 2-3 mins.


Now to parse the result, run the following command from ```results/scripts```
```shell
 bash per_category_parse_result.sh ../per_Category_Evaluation_BERT-FlakyLens.txt
 ```


For getting the results of other LLMs, run the following command (related to the RQ2). One example model to run is following command.

```shell
export HF_TOKEN=<hf_your_token_here>
bash per_project_prediction.sh FlakyLens "qwen"
```
Expected runtime is 50 to 55 mins. The result will be stored in ```FlakyLens_Categorization_PerProject-result/qwen.csv```

If you want to get the attribution score for the tokens, run the following command (related to the RQ3). This needs around 25~30 mins to finish. Attribution scores for each token is found ```Attributions_scores/```

```shell
bash per_project_prediction.sh FlakyLens "BERT" "calculate_gradient"
```

To apply perturbation, we need to run the following command. One example of applying one category of the perturbation (deadlock) is as follows.

```shell
bash per_project_prediction.sh FlakyLens "BERT" "deadcode_perturbation"
```



# Dataset

Our dataset is available in ```dataset/FlakyLens/FlakyLens_dataset_with_nonflaky_indented.csv```


# ************ =====================

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

# Hardware Requirement

We perform fine-tuning on a Linux machine equipped with a single NVIDIA RTX A5000 GPU, 125GB of RAM, and 24GB of GPU memory, utilizing CUDA version 12.0.

# To run Docker Image, run the following

```shell
docker build -t flakylens:latest .
docker run --gpus all -it --rm flakylens:latest
```
