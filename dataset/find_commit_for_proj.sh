collected="Flakicat/Flakicat_dataset_from_collected.csv" #project is with the owner, 2nd column contains sha
costa="Flakicat/Flakicat_dataset_from_costa_etal.csv" #only contains project, sha contains in column 11
habchi="Flakicat/Flakicat_dataset_from_habchi_etal.csv" ##project is with the owner, 2nd column contains sha
luoetal="Flakicat/Flakicat_dataset_from_luo_etal.csv" #only contains project, sha contains in column 2nd
ifixflakies="Flakicat/Flakicat_dataset_from_ifixflakies.csv" #only contains project, sha contains in column 2nd

input_file="filtered_tests.csv"
output_file="filtered_tests_with_sha.csv"

# Clear previous output file
> "$output_file"

while read line; do
    echo "$line"
    if [[ ${line} =~ ^\# ]]; then
        echo "Skipping comment line: $line"
        continue
    fi  

    proj=$(echo "$line" | cut -d',' -f2 | tr -d '[:space:]')  # Remove extra spaces
    proj_lower=$(echo "$proj" | tr '[:upper:]' '[:lower:]')  # Convert to lowercase

    # Function to search for SHA in a given file (case insensitive)
    find_sha() {
        awk -F',' -v proj="$proj_lower" '
        BEGIN { IGNORECASE = 1 }
        {
            split(tolower($1), arr, "/");  # Convert column to lowercase
            if (arr[2] == proj || tolower($1) == proj) {
                print "Matched in file:", FILENAME, "Project:", $1, "SHA:", $2 > "/dev/stderr";
                print $2;  # Match project name and print SHA
            }
        }' "$1"
    }   

    # Special function to handle costa (extract SHA from 11th column)
    find_sha_costa() {
        awk -F',' -v proj="$proj_lower" '
        BEGIN { IGNORECASE = 1 }
        {
            if (tolower($1) == proj) {
                print "Executing find_sha_costa for:", proj, "SHA:", $11 > "/dev/stderr";  # Debug info
                print $11;  # Extract SHA from the 11th column
            }
        }' "$1"
    }   

    # Special function to handle datasets where SHA is in 2nd column but project does not have an owner
    find_sha_simple() {
        awk -F',' -v proj="$proj_lower" '
        BEGIN { IGNORECASE = 1 }
        {
            if (tolower($1) == proj) {
                print "Matched simple project in:", FILENAME, "SHA:", $2 > "/dev/stderr";
                print $2;  # Extract SHA from the 2nd column
            }
        }' "$1"
    }

    # Search for SHA across datasets in order
    matched_shas=()  # Use an array to collect SHAs

    for dataset in "$collected" "$costa" "$habchi" "$ifixflakies" "$luoetal"; do
        echo "Checking dataset: '$dataset' for project: '$proj_lower'" > "/dev/stderr"
        shas=""

        case "$dataset" in
            "$collected" | "$habchi")
                shas=$(find_sha "$dataset")  # Extract SHA from 2nd column (with owner)
                ;;
            "$costa")
                shas=$(find_sha_costa "$dataset")  # Extract SHA from 11th column
                ;;
            "$ifixflakies" | "$luoetal")
                shas=$(find_sha_simple "$dataset")  # Extract SHA from 2nd column (no owner)
                ;;
        esac

        if [[ -n "$shas" ]]; then
            while IFS= read -r sha; do
                matched_shas+=("$sha")  # Append each SHA to array
            done <<< "$shas"
            break  # Stop searching once a match is found
        fi  
    done

    if [[ ${#matched_shas[@]} -gt 0 ]]; then
        joined_shas=$(IFS=';'; echo "${matched_shas[*]}")  # Join SHAs with semicolon
        echo "$proj,$joined_shas" >> "$output_file"
    else
        echo "No match found for project '$proj'" > "/dev/stderr"
    fi  

done < "$input_file"



#input_file="filtered_tests.csv"
#output_file="filtered_tests_with_sha_1.csv"
#
## Clear previous output file
#> "$output_file"
##
#while read line; do
#    if [[ ${line} =~ ^\# ]]; then
#        echo "Skipping comment line: $line"
#        continue
#    fi  
#
#    proj=$(echo "$line" | cut -d',' -f2 | tr -d '[:space:]')  # Remove extra spaces
#    proj_lower=$(echo "$proj" | tr '[:upper:]' '[:lower:]')  # Convert to lowercase
#
#    # Function to search for SHA in a given file (case insensitive)
#    find_sha() {
#        awk -F',' -v proj="$proj_lower" '
#        BEGIN { IGNORECASE = 1 }
#        {
#            split(tolower($1), arr, "/");  # Convert column to lowercase
#            if (arr[2] == proj || tolower($1) == proj) print $2;  # Match project name and print SHA
#        }' "$1"
#    }   
#
#
#    # Special function to handle costa (extract SHA from 11th column)
#    find_sha_costa() {
#        awk -F',' -v proj="$proj_lower" '
#        BEGIN { IGNORECASE = 1 }
#        {
#            if (tolower($1) == proj) {
#                print "Executing find_sha_costa for:", proj > "/dev/stderr";  # Print debug info to stderr
#                print $11;  # Extract SHA from the 11th column
#            }
#        }' "$1"
#    }
#
#    # Search for SHA across datasets in order
#    matched_shas=()  # Use an array to collect SHAs
#
#    for dataset in "$collected" "$costa" "$habchi" "$ifixflakies" "$luoetal"; do
#        shas=$(find_sha "$dataset")
#        dataset_cleaned=$(echo "$dataset" | tr -d '[:space:]')
#        costa_cleaned=$(echo "$costa" | tr -d '[:space:]')
#
#        if [[ -z "$shas" && "$dataset_cleaned" == "$costa_cleaned" ]]; then
#            echo "within condition"
#
#            shas=$(find_sha_costa "$dataset")
#        fi  
#
#        if [[ -n "$shas" ]]; then
#            while IFS= read -r sha; do
#                matched_shas+=("$sha")  # Append each SHA to array
#            done <<< "$shas"
#            break  # Stop searching once a match is found
#        fi  
#    done
#
#    if [[ ${#matched_shas[@]} -gt 0 ]]; then
#        joined_shas=$(IFS=';'; echo "${matched_shas[*]}")  # Join SHAs with semicolon
#        echo "$proj,$joined_shas" >> "$output_file"
#    else
#        echo "No match found for project '$proj'"
#    fi  
#    exit
#
#done < "$input_file"
#
#
