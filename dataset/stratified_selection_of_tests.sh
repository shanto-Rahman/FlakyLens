currentDir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
output_test_files="$currentDir/projects/Per-Proj-Info/apache_cassandra_test_files.txt"
cd "$currentDir/projects/cassandra/"
# Step 4: Select 1 or 2 random test classes
random_test_classes=$(shuf -n 2 "$output_test_files")

# Step 5: Extract test methods from selected test classes
selected_test_methods_file="$currentDir/projects/Per-Proj-Info/apache_cassandra_selected_test_methods.txt"
> "$selected_test_methods_file"

# Step 5: Extract test methods from selected test classes
#full_test_methods_file="$currentDir/projects/Per-Proj-Info/apache_cassandra_full_test_methods.txt"
#> "$selected_test_methods_file"
#> "$full_test_methods_file"
# Initialize CSV file with header
output_csv="$currentDir/projects/Per-Proj-Info/extracted_test_methods.csv"
echo "id,project,test_name,full_code,label,category" > "$output_csv"

id_counter=370  # ID starts from 1

for test_class_file in $random_test_classes; do
    project_name="apache_cassandra"
    test_class_name=$(basename "$test_class_file" .java)
    
    echo "Processing test class: $test_class_name"

    awk -v id="$id_counter" -v project="$project_name" -v test_class="$test_class_name" -v output_file="$output_csv" '
    BEGIN { inside_test = 0; method_body = ""; method_name = ""; bracket_count = 0; annotation = "" }

    /@Test|@ParameterizedTest|@RepeatedTest|@BeforeEach|@AfterEach|@BeforeAll|@AfterAll/ {
        annotation = $0; 
        inside_test = 1; 
        method_body = annotation "\n"; 
        next 
    }

    inside_test {
        if (match($0, /public[ ]+[^ ]+[ ]+([a-zA-Z0-9_]+)[ ]*\(/, m)) {
            method_name = m[1];
            method_body = method_body $0 "\n";
            bracket_count = gsub(/{/, "{", $0) - gsub(/}/, "}", $0);
            next;
        }

        if (method_name != "") {
            method_body = method_body $0 "\n";
            bracket_count += gsub(/{/, "{", $0) - gsub(/}/, "}", $0);
            if (bracket_count == 0) {
                # Escape double quotes for CSV formatting
                gsub(/"/, "\"\"", method_body);
                print id "," project "," test_class "." method_name ",\"" method_body "\",non-flaky,5" >> output_file;
                id++;
                inside_test = 0;
                method_body = "";
                method_name = "";
                annotation = "";
            }
        }
    }' "$test_class_file"
done

echo "Test methods extracted and saved to: $output_csv"

echo "Selected test method names saved to: $selected_test_methods_file"
#echo "Full test method bodies saved to: $full_test_methods_file"
