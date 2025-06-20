#!/bin/bash

# Define dataset files where the owner/project mapping exists
collected="Flakicat/Flakicat_dataset_from_collected.csv" #project is with the owner, 2nd column contains sha
costa="Flakicat/Flakicat_dataset_from_costa_etal.csv" #only contains project, sha contains in column 11
habchi="Flakicat/Flakicat_dataset_from_habchi_etal.csv" ##project is with the owner, 2nd column contains sha
luoetal="Flakicat/Flakicat_dataset_from_luo_etal.csv" #only contains project, sha contains in column 2nd
ifixflakies="Flakicat/Flakicat_dataset_from_ifixflakies.csv" #only contains project, sha contains in column 2nd

input_file="filtered_tests_with_sha.csv"  # Input file with project and commit hashes
output_file="filtered_tests_with_owner_sha.csv"  # Output file with updated project names

declare -A project_mapping  # Store project -> owner/project mapping
declare -A seen  # To track processed projects and avoid duplicates

# Function to find the full project name (owner/project)
#find_full_project_name() {
#    local proj_lower=$(echo "$1" | tr '[:upper:]' '[:lower:]')  # Convert to lowercase
#    local full_name=""
#
#    for dataset in "$collected" "$costa" "$habchi" "$ifixflakies" "$luoetal"; do
#        full_name=$(awk -F',' -v proj="$proj_lower" '
#        BEGIN { IGNORECASE = 1 }
#        {
#            if (index(tolower($1), proj) > 0) {
#                print $1;
#                exit;  # Stop after first match
#            }
#        }' "$dataset")
#
#        if [[ -n "$full_name" ]]; then
#            echo "Found mapping for '$proj_lower' → '$full_name' in dataset: $dataset" >&2
#            echo "$full_name"
#            return
#        fi  
#    done
#
#    echo "Project '$1' not found in any dataset!" >&2
#    echo "$1"  # Return original project name if no match is found
#}


find_full_project_name() {
    local proj_lower=$(echo "$1" | tr '[:upper:]' '[:lower:]')  # Convert to lowercase
    local full_name=""

    for dataset in "$collected" "$costa" "$habchi" "$ifixflakies" "$luoetal"; do
        full_name=$(awk -F',' -v proj="$proj_lower" '
        BEGIN { IGNORECASE = 1 }
        {
            split(tolower($1), arr, "/");  # Split into owner/repo
            owner = arr[1]; repo = arr[2];

            # Match against full name, repo, or owner
            if (tolower($1) == proj || repo == proj || owner == proj) {
                print $1;
                exit;  # Stop after first match
            }
        }' "$dataset")

        if [[ -n "$full_name" ]]; then
            echo "Found mapping for '$proj_lower' → '$full_name' in dataset: $dataset" >&2
            echo "$full_name"
            return
        fi  
    done

    echo "Project '$1' not found in any dataset!" >&2
    echo "$1"  # Return original project name if no match is found
}


# Read the input file and update project names
> "$output_file"  # Clear the output file before writing
while IFS=, read -r project commits; do
    if [[ -z "$project" || -z "$commits" ]]; then
        continue  # Skip empty lines
    fi

    flag=0
    # Get or retrieve the correct project name
    if [[ -z "${project_mapping[$project]}" ]]; then
        flag=1
        echo "⚠️ Project '$project' was not mapped to an owner/project" >> debug_log.txt
        project_mapping["$project"]=$(find_full_project_name "$project")
    fi

    full_project_name="${project_mapping[$project]}"

    # Ensure project is written only once
    if [[ -z "${seen[$full_project_name]}" ]]; then
        echo "$full_project_name,$commits" >> "$output_file"
        seen["$full_project_name"]=1  # Mark as processed
    elif [[ $flag == 1 ]]; then
       echo "Duplicate project found, $project" >> debug_log.txt
    fi

done < "$input_file"

echo "Updated file saved as $output_file"

