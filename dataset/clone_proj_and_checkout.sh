input_file="filtered_tests_with_owner_sha.csv"
currentDir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
inputProj=$currentDir"/projects"
outputDir="$2"
if [ ! -d "projects" ] 
then
    mkdir ${inputProj}
    mkdir "${inputProj}/Per-Proj-Info"
fi
output_nonflaky_csv="$currentDir/projects/Per-Proj-Info/extracted_test_methods.csv"
echo "id,project,test_name,full_code,label,category" > "$output_nonflaky_csv"
id_counter=281  # ID starts from 1

echo "slug,sha" >> "$currentDir/Successfully_found_proj_sha.csv"
while read line; do
    slug=$(echo $line | cut -d',' -f1)
    slug_with_underscore=$(echo "$slug" | sed 's/\//_/g')
    owner=$(echo $slug | cut -d'/' -f1)
    commit_list=$(echo $line | cut -d',' -f2)
    IFS=';' read -r -a sha_array <<< "$commit_list"  # Split multiple SHAs by semicolon
    echo "Processing repository: $slug"


    git clone "https://github.com/$slug" $inputProj/$slug
    cd $inputProj/$slug
    # Try each SHA one by one
    for sha in "${sha_array[@]}"; do
        git checkout "$sha" 2>/dev/null
        if [[ $? -eq 0 ]]; then
            echo "Successfully checked out to $sha for project $slug"
            echo "$slug,$sha" >> "$currentDir/Successfully_found_proj_sha.csv"
            break  # Stop after finding a valid SHA
        else
            echo "Failed to checkout $sha for project $slug" >> "$currentDir/Failed_proj_sha.csv"
        fi
    done

    dataset="$currentDir/Flakicat/Flakicat_dataset_with_nonflaky_indented.csv"
    output_test_files="$currentDir/projects/Per-Proj-Info/${slug_with_underscore}_test_files.txt"
    removed_tests="$currentDir/projects/Per-Proj-Info/${slug_with_underscore}_removed_test_classes.txt"


    find . -type f -name "*Test.java" -o -path "*/src/test/java/*.java" -o -path "*/test/*.java" > tmp.txt
    #Filter files that contain JUnit or TestNG annotations
    grep -lE "@Test|extends TestCase" $(cat tmp.txt) > $output_test_files
    # Step 3: Check if test classes exist in the dataset
    while read -r test_file; do
        test_class=$(basename "$test_file" .java)  # Extract class name
        match_count=$(grep -c ",$test_class" "$dataset")  # Check if test class exists in CSV
    
        if [[ "$match_count" -gt 0 ]]; then
            echo "$test_class" >> "$removed_tests"  # Store removed test class
            sed -i "/$test_class/d" "$output_test_files"  # Remove from test file list
        fi
    done < "$output_test_files"
    
    echo "Filtered test files saved to: $output_test_files"
    echo "Removed test classes saved to: $removed_tests"
    
    #Cleanup
    rm tmp.txt
    # Iterate over all test class files instead of picking only 2
    for test_class_file in $(cat "$output_test_files"); do
        project_name=$slug_with_underscore  # e.g., "apache_cassandra"
        test_class_name=$(basename "$test_class_file" .java)
        
        echo "Processing test class: $test_class_name"
    
        id_counter=$(awk -v id="$id_counter" -v project="$project_name" -v test_class="$test_class_name" -v output_file="$output_nonflaky_csv" '
        BEGIN { inside_test = 0; method_body = ""; method_name = ""; bracket_count = 0; annotation = ""; last_id = id }
    
        # Identify test-related annotations
        /@Test|@ParameterizedTest|@RepeatedTest|@BeforeEach|@AfterEach|@BeforeAll|@AfterAll/ {
            annotation = $0; 
            inside_test = 1; 
            method_body = annotation "\n"; 
            next 
        }
    
        # Capture method signature
        inside_test {
            if (match($0, /public[ ]+[^ ]+[ ]+([a-zA-Z0-9_]+)[ ]*\(/, m)) {
                method_name = m[1];
                method_body = method_body $0 "\n";
                bracket_count = gsub(/{/, "{", $0) - gsub(/}/, "}", $0);
                next;
            }
    
            # Capture method body
            if (method_name != "") {
                method_body = method_body $0 "\n";
                bracket_count += gsub(/{/, "{", $0) - gsub(/}/, "}", $0);
                if (bracket_count == 0) {
                    # Escape double quotes for CSV formatting
                    gsub(/"/, "\"\"", method_body);
                    print last_id "," project "," test_class "." method_name ",\"" method_body "\",non-flaky,5" >> output_file;
                    last_id++;
                    inside_test = 0;
                    method_body = "";
                    method_name = "";
                    annotation = "";
                }
            }
        } END { print last_id }' "$test_class_file")  # Return the last used ID
    
    done
    
    echo "Processed all test classes in: $output_test_files"
    
    #random_test_classes=$(shuf -n 2 "$output_test_files")

    ##selected_test_methods_file="$currentDir/projects/Per-Proj-Info/${slug_with_underscore}_selected_test_methods.txt"
    ##> "$selected_test_methods_file"

    #for test_class_file in $random_test_classes; do
    #    project_name=$slug_with_underscore #"apache_cassandra"
    #    test_class_name=$(basename "$test_class_file" .java)
    #    
    #    echo "Processing test class: $test_class_name"
    #
    #    #awk -v id="$id_counter" -v project="$project_name" -v test_class="$test_class_name" -v output_file="$output_nonflaky_csv" '
    #    id_counter=$(awk -v id="$id_counter" -v project="$project_name" -v test_class="$test_class_name" -v output_file="$output_nonflaky_csv" '
    #    BEGIN { inside_test = 0; method_body = ""; method_name = ""; bracket_count = 0; annotation = ""; last_id = id }
    #
    #    /@Test|@ParameterizedTest|@RepeatedTest|@BeforeEach|@AfterEach|@BeforeAll|@AfterAll/ {
    #        annotation = $0; 
    #        inside_test = 1; 
    #        method_body = annotation "\n"; 
    #        next 
    #    }
    #
    #    inside_test {
    #        if (match($0, /public[ ]+[^ ]+[ ]+([a-zA-Z0-9_]+)[ ]*\(/, m)) {
    #            method_name = m[1];
    #            method_body = method_body $0 "\n";
    #            bracket_count = gsub(/{/, "{", $0) - gsub(/}/, "}", $0);
    #            next;
    #        }
    #
    #        if (method_name != "") {
    #            method_body = method_body $0 "\n";
    #            bracket_count += gsub(/{/, "{", $0) - gsub(/}/, "}", $0);
    #            if (bracket_count == 0) {
    #                # Escape double quotes for CSV formatting
    #                gsub(/"/, "\"\"", method_body);
    #                print last_id "," project "," test_class "." method_name ",\"" method_body "\",non-flaky,5" >> output_file;
    #                last_id++;
    #                inside_test = 0;
    #                method_body = "";
    #                method_name = "";
    #                annotation = "";
    #            }
    #        }
    #    }    END { print last_id }' "$test_class_file")  # Return the last used ID

    #    #' "$test_class_file"
    #    # Increment id_counter after processing each test class
    #    #id_counter=$(($id_counter + 1))
    #done

    #cd $currentDir
    #echo "removing $inputProj/$owner"
    #exit
    #rm -rf $inputProj/$owner
done < "${input_file}"


