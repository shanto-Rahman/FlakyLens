import pandas as pd
#from collections import Counter
from collections import Counter, defaultdict
common_words={"is", "test", "than", "to", "until", "proof", "subscribed", "void", "409", "be", "1", "int", "Fn", "assert", "2", "any", "this", "long", "that", "200", "and", "parameters", "foo", "ictx", "foobar", "de", "ĉ", "ĉĉ", "ĉĉassert", "Hello", "other", "unit", "suppress", "client", "fn", "on"}
# Create DataFrame
df = pd.read_csv('Flakicat_Categorization_PerProject-result/output_attributions.csv') #iDataFrame(data)
#empty_rows = df[df["Attribution_Scores(Sorted)"].isna()]
#print(empty_rows)
# Check first few rows of the column
#print(df["Attribution_Scores(Sorted)"].head(10))

# Function to check for non-numeric values in the Attribution_Scores(Sorted) column
def find_non_numeric_scores(df, column_name):
    non_numeric_values = set()
    
    for scores in df[column_name].dropna():  # Drop NaN values to avoid errors
        for score in scores.split(";"):
            try:
                float(score)  # Try converting to float
            except ValueError:
                non_numeric_values.add(score)  # Collect non-numeric values
    
    return non_numeric_values


# Filter rows where True_Class == Predicted_Class
df_filtered = df[df["True_Class"] == df["Predicted_Class"]].copy()

# Multiply each attribution score by the confidence score
df_filtered["Updated_Attribution_Scores"] = df_filtered.apply(
    lambda row: ";".join([str(float(score) * row["Test_Confidence_Score"]) for score in row["Attribution_Scores(Sorted)"].split(";")]), axis=1
    #lambda row: ";".join([str(float(score)) for score in row["Attribution_Scores(Sorted)"].split(";")]), axis=1
    )
#print(df_filtered[df_filtered["True_Class"] == 1]["Tokens(Sorted by Importance)"].head())

df_filtered.to_csv("tmp.csv", index=False)

# Initialize a dictionary to store aggregated attribution scores for each category
aggregated_token_scores_per_category = {}

# Iterate through each category (True_Class)
'''for category in df_filtered["True_Class"].unique():
    # Select only the rows belonging to this category
    category_rows = df_filtered[df_filtered["True_Class"] == category]

    # Dictionary to accumulate attribution scores for each token
    token_score_dict = defaultdict(float)

    # Iterate through each row and accumulate scores per token
    for _, row in category_rows.iterrows():
        tokens = row["Tokens(Sorted by Importance)"].split(";")
        scores = row["Updated_Attribution_Scores"].split(";")  # This is now a list of floats
        
        # Ensure correct mapping between tokens and scores
        if len(tokens) != len(scores):
            print(f"Warning: Mismatch in token and score count for row: {row['Test_case']}")
            continue  # Skip this row if there's a mismatch

        # Ensure correct mapping between tokens and scores
        for token, score in zip(tokens, scores):
            try:
                #print("token=",token, ", score=", score)
                token_score_dict[token] += float(score)  # Ensure score is a float
            except ValueError:
                print(f"Skipping invalid score '{score}' for token '{token}' in category '{category}'")

    # Sort tokens by total attribution score in descending order and keep the top 100
    top_100_tokens = sorted(token_score_dict.items(), key=lambda x: x[1], reverse=True)[:30]
    filtered_top_tokens = [(token, score) for token, score in top_100_tokens if token.lower() not in common_words]

    # Print the tokens and their corresponding scores
    print(f"\n****Top 100 tokens for category {category}:")
    for token, score in filtered_top_tokens:
            print(f"Token: {token}, Score: {score}")
    #exit() 
    # Store only the tokens
    aggregated_token_scores_per_category[category] = [token for token, _ in top_100_tokens]'''
# Iterate through each category (True_Class)
for category in df_filtered["True_Class"].unique():
    # Select only the rows belonging to this category
    category_rows = df_filtered[df_filtered["True_Class"] == category]

    # Dictionary to store all attribution scores for each token
    token_scores_dict = defaultdict(list)
    token_count_dict = defaultdict(int)  # To count occurrences

    # Iterate through each row and collect scores per token
    for _, row in category_rows.iterrows():
        tokens = row["Tokens(Sorted by Importance)"].split(";")
        scores = row["Updated_Attribution_Scores"].split(";")  # This is now a list of floats
            
        # Ensure correct mapping between tokens and scores
        if len(tokens) != len(scores):
            print(f"Warning: Mismatch in token and score count for row: {row['Test_case']}")
            continue  # Skip this row if there's a mismatch

        # Collect scores and count occurrences
        for token, score in zip(tokens, scores):
            try:
                token_scores_dict[token].append(float(score))  # Store all scores
                token_count_dict[token] += 1  # Count occurrences
            except ValueError:
                print(f"Skipping invalid score '{score}' for token '{token}' in category '{category}'")

    '''# Sort tokens by occurrence count in descending order
    sorted_tokens_by_count = sorted(token_count_dict.items(), key=lambda x: x[1], reverse=True)

    # Print sorted results
    print(f"\n==== Token Statistics for category {category} ====")
    for token, count in sorted_tokens_by_count:
        print(f"Token: {token}, Count: {count}, Scores: {token_scores_dict[token]}") 
    exit()'''
  
    
    # Print token occurrences and their scores
    #print(f"\n==== Token Statistics for category {category} ====")
    #for token, scores in token_scores_dict.items():
    #    print(f"Token: {token}, Count: {token_count_dict[token]}, Scores: {scores}")

    # Sum up attribution scores for each token
    token_score_sums = {token: sum(scores) for token, scores in token_scores_dict.items()}

    # Sort tokens by total attribution score in descending order and keep the top 100
    top_100_tokens = sorted(token_score_sums.items(), key=lambda x: x[1], reverse=True)[:20]
    
    # Filter out common words
    filtered_top_tokens = [(token, score) for token, score in top_100_tokens if token.lower() not in common_words]

    # Print the tokens and their corresponding scores after summing
    #print(f"\n**** Top 100 tokens for category {category}:")
    #for token, score in filtered_top_tokens:
    #    print(f"Token: {token}, Score: {score}")

    # Store only the tokens
    aggregated_token_scores_per_category[category] = [token for token, _ in filtered_top_tokens]
    # Initialize token occurrence count for the top 100 tokens
    top_token_occurrence_count = defaultdict(int)

    # Reiterate through the original data to count actual occurrences
    for _, row in df_filtered.iterrows():
        tokens = row["Tokens(Sorted by Importance)"].split(";")
        for token in tokens:
            if token in aggregated_token_scores_per_category[category]:
                top_token_occurrence_count[token] += 1  # Count occurrence from original data

    # Print the actual occurrence count for the top 100 tokens
    print(f"\n==== Actual Occurrences for Top 100 Tokens in category {category} ====")
    for token in aggregated_token_scores_per_category[category]:
        print(f"Token: {token}, Count: {top_token_occurrence_count[token]}")

    '''# Sort the tokens based on their occurrence count in descending order
    sorted_tokens_by_count = sorted([(token, top_token_occurrence_count[token]) for token in aggregated_token_scores_per_category[category]], key=lambda x: x[1],  # Sort by count
        reverse=True)

    # Print the sorted tokens and their occurrence counts
    print(f"\n==== Actual Occurrences for Top 100 Tokens in category {category} (Sorted by Count) ====")
    for token, count in sorted_tokens_by_count:
        print(f"Token: {token}, Count: {count}")'''

'''exit()

print("Top 100 tokens per category (based on summed attribution scores):")
print(aggregated_token_scores_per_category)

# Now extract most frequent tokens
most_frequent_tokens_per_category = { 
    category: list(Counter(tokens).keys())[:5]  # Ensure safe extraction
    for category, tokens in aggregated_token_scores_per_category.items()
}

print("\nMost frequent 5 tokens per category:")
print(most_frequent_tokens_per_category)'''
