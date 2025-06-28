# Understanding_and_Improving_FlakyTest_Classifiers_Artifact

# Purpose
This README accompanies the artifact for the paper "Understanding and Improving Flaky Test Classification." This work introduces a new dataset that combines flaky and non-flaky tests, resulting in a more realistic distribution of test categories. The paper also presents a classification approach using fine-tuned models to predict the category of each test.

The primary goal of this artifact is to provide access to the dataset, training and inference code, and scripts for interpreting model predictions by identifying key features with attribution scores.

We are applying for the "Available" and "Functional" badges. The dataset and code are publicly accessible via a Zenodo link, and all scripts are fully executable, enabling others to reproduce our results and extend the work.

# Provenance

The artifact can be obtained from https://zenodo.org/records/??? in the form of a Docker image. Note that the size of our Docker image including the dataset is about ???GB, so please prepare sufficient disk space.

# Requirements

docker

NVIDIA GPU

Disk Space ???GB


# Hardware Requirement

We perform fine-tuning on a Linux machine equipped with a single NVIDIA RTX A5000 GPU, 125GB of RAM, and 24GB of GPU memory, utilizing CUDA version 12.0.

# Setup 
After downloading flakylens_latest.tar.gz from the Zenodo link, load it into Docker:

```shell
docker load < flakylens_latest.tar.gz
```

Ensure that your user is added to the docker group to interact with the Docker daemon without needing sudo. If you're not already a member of the docker group, please follow these instructions to run Docker commands as a non-root user: https://docs.docker.com/engine/install/linux-postinstall/.

To start a Docker container, use the following command:

# Dataset

Our dataset is available in ```dataset/FlakyLens/FlakyLens_dataset_with_nonflaky_indented.csv```

Our dataset includes six types of tests — five categories of flaky tests and one non-flaky category. It comprises a total of 8,574 tests collected from 97 projects.
Each row in the dataset provides the project name, test name, test method body, and its corresponding test category.


```shell
docker run --gpus all -it --rm flakylens:latest
```

We evaluated our artifact on our end using Docker version 20.10.21, build 20.10.21-0ubuntu1~20.04.2.


# Usage

This repository supports running four major research questions (RQs) from our study.

---

## RQ1: Run Prediction with FlakyLens

To evaluate the predictive performance of **FlakyLens**, run:

```bash
bash rq1.sh
```

This will print the precision, recall, and F1-score for each category to the console.
Estimated runtime: ~2–3 minutes.

## RQ2: Predicting Flaky Tests with Other LLMs
To evaluate other language models (e.g., Qwen) for flaky test prediction, run:

```shell
export HF_TOKEN=<your_huggingface_token>
bash per_project_prediction.sh FlakyLens "qwen"
```

The output will be saved to: ```FlakyLens_Categorization_PerProject-result/qwen.csv```
Estimated runtime: ~50–55 minutes.

## RQ3: Token-Level Attribution Analysis

To calculate attribution scores for each token using gradient-based analysis, run:
```shell
bash per_project_prediction.sh FlakyLens "BERT" "calculate_gradient"
```
The attribution results will be stored in: ```Attributions_scores/```

Estimated runtime: ~25–30 minutes.

## RQ4: Perturbation-Based Robustness Evaluation
To evaluate the model under code perturbations (e.g., deadlock injection), run:

```shell
bash rq4.sh
```
This will print the precision, recall, and F1-score for each category.
Estimated runtime: ~5 minutes.


# Finetuned Models

Use the following instructions to run through our artifact. Our models are placed into ```models/```

