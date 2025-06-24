# STEP 1: Choose a CUDA-enabled Base Image from NVIDIA
# Uses CUDA 12.0.1 with cuDNN 8 on Ubuntu 22.04, ideal for RTX A5000 and your specified CUDA.
FROM nvidia/cuda:12.0.1-cudnn8-devel-ubuntu22.04

# Set non-interactive mode for apt-get to prevent prompts
ENV DEBIAN_FRONTEND=noninteractive

# Set Python environment variables
ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

# STEP 2: Install Python 3.8.5 and pip (since you specified python=3.8.5 in your README)
# We'll use the default system Python if it's 3.8.5, or install it.
# It's often simpler to install a specific Python version using `apt-get` or `miniconda`
# For exact version control like 3.8.5, installing Miniconda is usually more straightforward.
# Let's stick with Miniconda for precise version control as implied by your README's `conda create`
RUN apt-get update && \
    apt-get install -y --no-install-recommends wget bzip2 ca-certificates git build-essential && \
    rm -rf /var/lib/apt/lists/*

RUN wget https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh -O miniconda.sh && \
    bash miniconda.sh -b -p /opt/conda && \
    rm miniconda.sh

ENV PATH="/opt/conda/bin:$PATH"

# Create a Conda environment for Python 3.8.5, as per your README
# We'll then use pip within this environment.
RUN conda create -n flakylense python=3.8.5 -y && \
    conda clean --all -f -y

# Set the default shell to use the new Conda environment
SHELL ["conda", "run", "-n", "flakylense", "/bin/bash", "-c"]

# STEP 3: Set the working directory and copy files
WORKDIR /app
COPY requirements.txt .
COPY . /app/ # Copies all other project files

# STEP 4: Install Python dependencies from requirements.txt
# This is where your requirements.txt comes in.
# If PyTorch needs a specific index-url (like for cu121), add it here.
# For example: pip install --no-cache-dir -r requirements.txt --extra-index-url https://download.pytorch.org/whl/cu121
RUN pip install --no-cache-dir -r requirements.txt

# Ensure the 'src' directory is the working directory for running scripts
WORKDIR /app/src

# Command to keep the container running so you can execute commands manually
# This is useful for interactive work, training, and running prediction scripts.
CMD ["bash"]
