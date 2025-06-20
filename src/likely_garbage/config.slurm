#!/bin/bash
#----------------------------------------------------
# Sample Slurm job script
#----------------------------------------------------
#SBATCH --partition=gpu-a100-small
#SBATCH --job-name=flakify
#SBATCH -N 1                             # Total # of nodes (must be 1 for serial)
#SBATCH -n 1                             # Total # of mpi tasks (should be 1 for serial)
#SBATCH -t 24:00:00                      # Run time (hh:mm:ss)
#SBATCH --output=/scratch/08545/shanto/%x_%j.out  # Standard output log
#SBATCH --error=/scratch/08545/shanto/%x_%j.err   # Standard error log
#SBATCH --mail-type=FAIL       # Notifications for job done & fail
#SBATCH --mail-user=shanto.rahman@utexas.edu
#SBATCH --mail-type=all                  # Send email at begin and end of job (can assign begin or end as well)

#SBATCH -A CCR23047                 # Allocation name

# Load the necessary modules first

module reset
module unload python2
module load cuda/12.0
module list


unset PYTHONPATH

module load gcc/9.4.0
source /work/08545/shanto/ls6/miniconda3/etc/profile.d/conda.sh
conda init bash
conda activate /work/08545/shanto/ls6/miniconda3/envs/FF1

#export CUDA_HOME=/opt/apps/cuda/12.0/


# Source conda and activate the environment
echo "Using conda environment: $(conda info --envs | grep 'flakify')"
#echo "Which Python: $(which python)"

#echo "Checking installed packages in the environment:"
#conda list
# Launch code...
bash $WORK/FT-Categorization/src/runAll.sh > $WORK/FT-Categorization/YYY

# ---------------------------------------------------

