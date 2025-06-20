import csv
import pandas as pd
# Define the file paths
input_file = "test_name.csv"
output_file = "IDoFT/Flakify_IDoFT_dataset.csv"
new_df= pd.read_csv(input_file)
existing_df= pd.read_csv(output_file)

merged_df = pd.merge(existing_df, new_df[['test_case_name', 'category']], on='test_case_name')
merged_df.to_csv('IDoFT/IDoFT_dataset.csv', index=False)
