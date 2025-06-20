import pandas as pd
import boto3
import sys
import ast
from access_in_claude import BedrockClientWithAutoRefresh
#from save_result import claude_result_changed_fm_save_to_file
import os
#from prompt_engineering import generate_promt_for_change_curation
import json
#from modify_python_file import hack_into_sut
import time
import subprocess
import re

role_arn = "arn:aws:iam::852483370298:role/bedrock_access_share_with_intern"
session_name = "BedrockSession"
bedrock_client = BedrockClientWithAutoRefresh(role_arn, session_name)

MODEL_IDS = [
    #"amazon.titan-text-express-v1",
    #"amazon.titan-text-lite-v1",
    #"anthropic.claude-3-sonnet-20240229-v1:0",
    "anthropic.claude-3.5-sonnet-20240229-v1:0",
    #"anthropic.claude-3-haiku-20240307-v1:0",
    #"meta.llama3-70b-instruct-v1:0",
    #"mistral.mistral-large-2402-v1:0",
    #"mistral.mixtral-8x7b-instruct-v0:1",
    #"mistral.mistral-7b-instruct-v0:2",
    ]

def generate_prompt(token_df, attribution_df):
    #print(relevant_test)
    java_code = f"""
    try {{
        Thread.sleep(100);
    }} catch (InterruptedException e) {{
        System.out.println("Thread was interrupted");
    }}
    """

    prompt = f"""You are provided with two dataframes: one containing code tokens and the other detailing their attribution scores. Attribution scores evaluate the importance of each token within a specific context.

Objective: Your task is to construct a Java code snippet within the confines of a predefined Java method. The code snippet should be syntactically correct, compilable, and self-contained within the method's body. It should not require modifications outside the method or additional imports.

Instructions:

1. Review the tokens and their attribution scores to understand their significance.
2. The snippet does not create instances of unverified classes. 
3. Develop a Java code snippet that can be directly inserted into a Java method. Ensure the code is concise, not exceeding five lines, and maintains logical coherence.
4. For example, if the tokens include "Thread" and "sleep," you might propose the following code:
   {java_code} 


Tokens Dataframe:
{token_df}

Attribution Scores Dataframe:
{attribution_df}
    """
    return prompt

def query_claude(client, prompt, temperature=0, top_p=0.9):
    # change it to the API you want
    payload = {
        "modelId": "anthropic.claude-3-sonnet-20240229-v1:0",
        "contentType": "application/json",
        "accept": "application/json",
        "body": {
            "anthropic_version": "bedrock-2023-05-31",
            "max_tokens": 1000,
            "temperature" : temperature,
            "top_p" : top_p,
            "messages": [
                {
                    "role": "user",
                    "content": [
                        {
                            "type": "text",
                            "text": prompt,
                        }
                    ]
                }
            ]
        }
    }

    # Convert the payload to bytes
    body_bytes = json.dumps(payload['body']).encode('utf-8')

    response = client.invoke_model(
        body=body_bytes,
        contentType=payload['contentType'],
        accept=payload['accept'],
        modelId=payload['modelId']
    )
    response_body = response['body'].read().decode('utf-8')
    text_response = json.loads(response_body)["content"][0]["text"]
    #print(text_response)
    return text_response

def get_function_code(filename, function_name):
    """Extracts and returns the complete source code of a function from a given Python file."""
    with open(filename, "r") as source:
        tree = ast.parse(source.read())

    for node in ast.walk(tree):
        if isinstance(node, ast.FunctionDef) and node.name == function_name:
            # Extract the whole function as source code including signature
            return ast.unparse(node)  # For Python 3.9+
            # For Python versions < 3.9, use the following method:
            # from astor import to_source
            # return to_source(node)

    return None  # Return None if the function is not found

def check_llm_response(response):
    match = re.search(r'```python(.*?)```', response, re.DOTALL)
    if match:
        # Extract the code between the backticks
        print("extracting codes from backticks ***")
        cleaned_code = match.group(1).strip()
        print(cleaned_code)
        hack_into_sut(cleaned_code, fm_file_path, fm_name, fm_lines)
        return cleaned_code
    return ""

def run_test(response, fm_file_path, fm_name, fm_lines, unit_test_name, test_file_path, intention): 
    cleaned_code =check_llm_response(response)
    if cleaned_code != "":
        response = cleaned_code
   
    hack_into_sut(response, fm_file_path, fm_name, fm_lines)  

    script_name = "./run_test_after_adding_change_in_fm.sh"
    #calling script to run the test
    try:
        result = subprocess.run([script_name, proj_name, fm_name, unit_test_name, test_file_path, response, intention], check=True, text=True, capture_output=True)
        print("Script output:", result.stdout)
    except subprocess.CalledProcessError as e:
        print(f"An error occurred while running the script: {e}")
        print("Error output:", e.stderr)
    except FileNotFoundError as e:
        print(f"Script file not found: {e}")
    except PermissionError as e:
        print(f"Permission error: {e}")


def gpt_score_finder(input_file, output_directory_path, experiment_type):
    input_directory_path = ""

    batch_size = 1
    pause_duration = 10
    od_test_df = pd.read_csv(input_file)
    prompt = generate_prompt(od_test_df['Token'], od_test_df['Total_Attribution'])
    od_test_df['Combined'] = od_test_df['Token'].astype(str) + ", " + od_test_df['Total_Attribution'].astype(str)

    # Print the combined column
    print(od_test_df['Combined'])
    runtime = []
    start_time = time.time() 
    #response = query_claude(prompt)
    response = bedrock_client.make_bedrock_call(query_claude, prompt)
    print(response)
    exit() 

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


if __name__ == "__main__":
    input_dir = sys.argv[1]
    output_directory_path = sys.argv[2]
    
    for fold in range(5):
        input_file=input_dir+"detokenization/Flakicat_category_"+str(fold)+".csv"
        print(input_file)

        experiment_type = "deadcode"
        gpt_score_finder(input_file, output_directory_path, experiment_type)

    '''file_name = file_path.split('/')[-1]
    df = pd.read_csv(file_path)
    #print(filename)
    for index, row in df.iterrows():
        #print(f"Processing row {index}:")
        print(f"Project Name: {row['proj_name']}")
        proj_name = row['proj_name'] 
        fm_file_path = row['fm_filename']
        test_file_path = row['test_filename']
        unit_test_name = row['test_method']
        fm_name = row['fm_method']
        fm_lines = row['fm_line_num']
        test_lines = row['test_line_num']

        with open(fm_file_path, 'r') as file:
            fm_file_content = file.read()
        with open(test_file_path, 'r') as file:
            test_file_content = file.read()
        print("-----\n")
        outputDir = "Results"
        if not os.path.exists(outputDir):
            print('Making output dir')
            os.makedirs(outputDir, exist_ok=True)
        unit_test_body = get_function_code(test_file_path, unit_test_name)
        print("**************")
        test_pass = False
        reduced_cc = False

        while not test_pass and not reduced_cc:
            prompt_to_reduce_code_coverage = generate_promt_for_change_curation_to_reduce_cc(test_file_path, test_file_content, unit_test_name, test_lines, fm_file_path, fm_file_content, fm_name, fm_lines)
            response = bedrock_client.make_bedrock_call(query_claude, prompt_to_reduce_code_coverage)
            #print('curated_change fm=',response)
            run_test(response, fm_file_path, fm_name, fm_lines, unit_test_name, test_file_path, "aim_to_reduce_coverage")
            #look for logs, then will decide 
            test_pass = True
            reduced_cc = True
             
            time.sleep(5)

        
        prompt_to_make_test_fail = generate_promt_for_change_curation_to_test_fail(test_file_path, test_file_content, unit_test_name, test_lines, fm_file_path, fm_file_content, fm_name, fm_lines)
        response = bedrock_client.make_bedrock_call(query_claude, prompt_to_make_test_fail)
        run_test(response, fm_file_path, fm_name, fm_lines, unit_test_name, test_file_path, "aim_to_test_fail")
        time.sleep(5)'''

