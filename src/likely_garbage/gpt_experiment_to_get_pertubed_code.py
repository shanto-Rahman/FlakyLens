import pandas as pd
import openai
import os
import time
import sys

def generate_prompt(token_df, attribution_df):
    #print(relevant_test)
    prompt = f"""Using two provided dataframes—one containing code tokens and the other their respective attribution scores—your task is to write a compilable Java snippet. Attribution scores indicate the importance of each token in the context of identifying or handling dead code.

    Compose a Java code snippet, up to five lines, utilizing these tokens effectively. You may incorporate additional tokens as necessary to ensure the code is syntactically correct and logically coherent. The dataframes with tokens and their attribution scores are as follows:

    # Tokens and their attribution scores:
    {token_df}
    {attribution_df}"""
    print(prompt)

    return prompt


def make_request_with_retry(prompt, max_retries=3, initial_wait=1, temperature=0):
    retry_count = 0
    while retry_count < max_retries:
        try:
            response = openai.ChatCompletion.create(
                model="gpt-3.5-turbo-0125",  # Adjust if necessary
                temperature=temperature,
                messages=[
                    {"role": "system", "content": "You are a highly knowledgeable code analysis AI."},
                    {"role": "user", "content": prompt}
                ],
                #temperature=1,
            )
            return response
        except openai.error.APIError as e:
            # Check if it's a server-side error (500, 502, 503, etc.)
            if hasattr(e, 'response') and e.response.status_code >= 500:
                print(f"Server error ({e.response.status_code}). Retrying in {initial_wait * (2 ** retry_count)} seconds.")
                time.sleep(initial_wait * (2 ** retry_count))  # Exponential backoff
                retry_count += 1
            else:
                print(f"API error: {str(e)}")
                raise  # Re-raise the exception for non-server-side errors or if retries are exhausted
        except Exception as e:
            # Catch any other unexpected errors
            print(f"Unexpected error: {str(e)}")
            raise 
    print("Max retries reached, unable to complete request.")
    return None  # or raise an exception indicating the request ultimately failed


def gpt_score_finder(input_file, output_directory_path, experiment_type):
    input_directory_path = ""

    #od_column_name = ""
    #od_code_column_name = ""
    #od_relevant_column_name = ""
    #od_relevant_code_column_name = ""
    #input_directory_path = ""
    #short_name = "" 
    #os.makedirs(output_directory_path, exist_ok=True)
    #if experiment_type == "BSS":
    #    od_column_name = "brittle"
    #    od_code_column_name = "brittle_code"
    #    od_relevant_column_name = "ss_or_nss"
    #    od_relevant_code_column_name = "ss_or_nss_code"
    #    input_directory_path = "../BSS_Per_Brittle"
    #    short_name = "BSS"
    #    relevant_test = "state-setter"

    #elif experiment_type == "VictimPolluter":
    #    od_column_name = "victim"
    #    od_code_column_name = "victim_code"
    #    od_relevant_column_name = "p_or_np"
    #    od_relevant_code_column_name = "p_or_np_code"
    #    input_directory_path = "../VP_Per_Victim"
    #    short_name = "VP"
    #    relevant_test = "polluter"

    
    batch_size = 1  # Define the size of each batch
    pause_duration = 10  # Define the pause duration in seconds
    od_test_df = pd.read_csv(input_file) #Extracting 135 Victims or 20 Brittles or 285 VP
    #print(od_test_df['Token'])
    #print(od_test_df['Total_Attribution'])
    #print(od_relevant_test)
    prompt = generate_prompt(od_test_df['Token'], od_test_df['Total_Attribution'])
    #print(prompt)
    od_test_df['Combined'] = od_test_df['Token'].astype(str) + ", " + od_test_df['Total_Attribution'].astype(str)

    # Print the combined column
    print(od_test_df['Combined'])
    runtime = []
    start_time = time.time() 
    response = make_request_with_retry(prompt)
    
    if response: 
        response_content = response['choices'][0]['message']['content']
    
        print("RESPONSE CONTENT =============================")
        print(response_content)
    
        scores = response_content.split()
        print("SCORES:")
        print(scores)
    
        processed_count=0
        results = []
        # Assuming scores format is [vp_true_score, vp_not_true_score]
        if len(scores) == 2:
            vp_true_score, vp_not_true_score = scores 
            result = {
                "proj": od_test_row['project'],
                "module": od_test_row['module'],
                "victimtest": od_test["test_name"],
                "othertest": od_relevant_test[od_relevant_column_name],
                "score_for_polluter(class1)": vp_true_score,
                "score_for_not_polluter(class0)": vp_not_true_score
            }
            #print(result) 
            print(csv_file_path)
    
            pd.DataFrame([result]).to_csv(csv_file_path, mode='a', index=False, header=not os.path.exists(csv_file_path))
            processed_count += 1
            end_time = time.time()
            elapsed_time = end_time - start_time

            runtime = {
                "category": "is"+experiment_type+"Pair", 
                "proj": od_test_row['project'],
                "module": od_test_row['module'],
                "victimtest": od_test["test_name"],
                "othertest": od_relevant_test[od_relevant_column_name],
                "gpt-search-runtime": elapsed_time,
                "order-id": fail_order
            }
            pd.DataFrame([runtime]).to_csv(runtime_csv_file_path, mode='a', index=False, header=not os.path.exists(runtime_csv_file_path))
            if processed_count % batch_size == 0:
                print(f"Processed {processed_count} items, pausing for {pause_duration} seconds.")
                time.sleep(pause_duration)  # Pause execution to avoid hitting rate limits
                # Implementing pause mechanism
                pass
            
    else:
        print("Request failed after retries.")
                
if  __name__ == "__main__":

    input_dir = sys.argv[1] #attributions_deadcode_perturbation/
    # Set your OpenAI API key
    #openai.api_key = "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"
    
    # Load the reference data from data2.csv
    # Directory containing the VP_Per_Brittle CSV files
    #base_directory_path = "VP_Per_Brittle"
    #input_directory_path = sys.argv[1] #"BSS_Per_Brittle"

    output_directory_path = sys.argv[2] #"GPT_Results"
    for fold in range(5):
        input_file=input_dir+"detokenization/Flakicat_category_"+str(fold)+".csv"
        print(input_file)

        experiment_type = "deadcode" #sys.argv[3]
        gpt_score_finder(input_file, output_directory_path, experiment_type)

    # DataFrame to store the final results
    #results_df = pd.DataFrame()
