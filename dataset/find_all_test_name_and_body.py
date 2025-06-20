###import os
###import re
###import csv
###import sys
###
###def find_java_files(test_directory):
###    """Find all Java files in the given directory recursively."""
###    java_files = []
###    for root, dirs, files in os.walk(test_directory):
###        for file in files:
###            if file.endswith(".java"):
###                java_files.append(os.path.join(root, file))
###    return java_files
###
###def extract_package_and_class_name(java_file):
###    """Extract the package and class name from a Java file."""
###    package_name = None
###    class_name = None
###    with open(java_file, 'r', encoding='utf-8') as file:
###        content = file.read()
###        package_match = re.search(r'^\s*package\s+([\w\.]+);', content, re.MULTILINE)
###        if package_match:
###            package_name = package_match.group(1)
###        class_match = re.search(r'^\s*public\s+class\s+(\w+)', content, re.MULTILINE)
###        if class_match:
###            class_name = class_match.group(1)
###    return package_name, class_name
###
###def extract_test_methods(file_path):
###    """Extract test methods and their full content from a Java file."""
###    test_methods = []
###    with open(file_path, 'r', encoding='utf-8') as file:
###        code = file.read()
###    
###    # Match @Test and the method body
###    method_pattern = r'(@Test[\s\S]*?)(public|private|protected)?\s+[\w<>]+\s+([\w]+)\s*\([\s\S]*?\)\s*\{([\s\S]*?)}'
###    matches = re.finditer(method_pattern, code)
###
###    for match in matches:
###        full_declaration = match.group(0)
###        method_name = match.group(3)
###        full_body = match.group(4)
###
###        # Compute package and class names
###        package_name = None
###        class_name = None
###        with open(file_path, 'r') as f:
###            for line in f:
###                if line.startswith("package"):
###                    package_name = line.split()[1].rstrip(";")
###                elif line.startswith("public class") or line.startswith("class"):
###                    class_name = line.split()[2].split("{")[0]
###                    break
###        
###        if package_name and class_name:
###            test_full_path = f"{package_name}.{class_name}.{method_name}"
###            test_methods.append((test_full_path, full_declaration))
###         
###    return test_methods
###
###def extract_full_body(content, start_index):
###    """Extract the full body of a method, accounting for nested braces."""
###    brace_count = 0
###    method_body = []
###    inside_method = False
###
###    for i in range(start_index, len(content)):
###        char = content[i]
###
###        if char == '{':
###            brace_count += 1
###            inside_method = True
###
###        if inside_method:
###            method_body.append(char)
###
###        if char == '}':
###            brace_count -= 1
###            if brace_count == 0:
###                # Found the matching closing brace for the method
###                break
###
###    if brace_count == 0:
###        return ''.join(method_body)
###    else:
###        # If braces are not balanced, return None
###        return None
###
###def main(test_directory, output_csv, proj_name):
###    """Main function to find all test methods in a Maven test directory."""
###    java_files = find_java_files(test_directory)
###    all_test_methods = []
###    count_id = 0
###    for java_file in java_files:
###        package_name, class_name = extract_package_and_class_name(java_file)
###        test_methods = extract_test_methods(java_file)
###
###        for method_name, method_content in test_methods:
###            count_id +=1 
###            if package_name and class_name:
###                full_path = f"{package_name}.{class_name}.{method_name}"
###            elif class_name:
###                full_path = f"{class_name}.{method_name}"
###            else:
###                full_path = method_name
###            all_test_methods.append((count_id, proj_name, full_path, method_content))
###
###
###    # Write to CSV
###    with open(output_csv, 'w', newline='', encoding='utf-8') as csvfile:
###        writer = csv.writer(csvfile)
###        
###        writer.writerow(['id', 'proj_name', 'test_full_path', 'full_code'])
###        writer.writerows(all_test_methods)
###    print(f"Extracted test methods have been saved to {output_csv}") 
###
###
###if __name__ == "__main__":
###    # Change this path to your Maven test directory
###    test_directory = sys.argv[1]
###    proj_name = sys.argv[2]
###    output_csv = proj_name+"_test_methods.csv"
###    main(test_directory, output_csv, proj_name)
##
##import os
##import re
##import csv
##import sys
##
##def find_java_files(test_directory):
##    """Find all Java files in the given directory recursively."""
##    java_files = []
##    for root, _, files in os.walk(test_directory):
##        for file in files:
##            if file.endswith(".java"):
##                java_files.append(os.path.join(root, file))
##    return java_files
##
##def extract_package_and_class_name(java_file):
##    """Extract the package and class name from a Java file."""
##    package_name = None
##    class_name = None
##    with open(java_file, 'r', encoding='utf-8') as file:
##        content = file.read()
##        package_match = re.search(r'^\s*package\s+([\w\.]+);', content, re.MULTILINE)
##        if package_match:
##            package_name = package_match.group(1)
##        class_match = re.search(r'^\s*public\s+class\s+(\w+)', content, re.MULTILINE)
##        if class_match:
##            class_name = class_match.group(1)
##    return package_name, class_name
##
##def extract_test_methods(file_path):
##    """Extract test methods and their full content from a Java file."""
##    test_methods = []
##    with open(file_path, 'r', encoding='utf-8') as file:
##        code = file.read()
##    
##    # Match @Test and the method body
##    method_pattern = r'(@Test[\s\S]*?)(public|private|protected)?\s+[\w<>]+\s+([\w]+)\s*\([\s\S]*?\)\s*\{'
##    matches = re.finditer(method_pattern, code)
##
##    for match in matches:
##        full_declaration = match.group(0)  # Declaration + start of body
##        method_name = match.group(3)
##        start_index = match.end() - 1  # Start after the opening brace
##
##        # Extract the full method body using braces
##        full_body = extract_full_body(code, start_index)
##        if full_body:
##            full_code = full_declaration + full_body  # Combine declaration and body
##            test_methods.append((method_name, full_code))
##    
##    return test_methods
##
##def extract_full_body(content, start_index):
##    """Extract the full body of a method, accounting for nested braces."""
##    brace_count = 0
##    method_body = []
##    inside_method = False
##
##    for i in range(start_index, len(content)):
##        char = content[i]
##
##        if char == '{':
##            brace_count += 1
##            inside_method = True
##
##        if inside_method:
##            method_body.append(char)
##
##        if char == '}':
##            brace_count -= 1
##            if brace_count == 0:
##                # Found the matching closing brace for the method
##                break
##
##    if brace_count == 0:
##        return ''.join(method_body)
##    else:
##        # If braces are not balanced, return None
##        return None
##
##def main(test_directory, output_csv, proj_name):
##    """Main function to find all test methods in a Maven test directory."""
##    java_files = find_java_files(test_directory)
##    all_test_methods = []
##    count_id = 0
##    for java_file in java_files:
##        package_name, class_name = extract_package_and_class_name(java_file)
##        test_methods = extract_test_methods(java_file)
##
##        for method_name, method_content in test_methods:
##            count_id += 1
##            if package_name and class_name:
##                full_path = f"{package_name}.{class_name}.{method_name}"
##            elif class_name:
##                full_path = f"{class_name}.{method_name}"
##            else:
##                full_path = method_name
##            all_test_methods.append((count_id, proj_name, full_path, method_content))
##
##    # Write to CSV
##    with open(output_csv, 'w', newline='', encoding='utf-8') as csvfile:
##        writer = csv.writer(csvfile)
##        writer.writerow(['id', 'proj_name', 'test_full_path', 'full_code'])
##        writer.writerows(all_test_methods)
##
##    print(f"Extracted test methods have been saved to {output_csv}")
##
##if __name__ == "__main__":
##    # Change this path to your Maven test directory
##    test_directory = sys.argv[1]
##    proj_name = sys.argv[2]
##    output_csv = proj_name + "_test_methods.csv"
##    main(test_directory, output_csv, proj_name)
#
#import os
#import re
#import csv
#import sys
#
#def find_java_files(test_directory):
#    """Find all Java files in the given directory recursively."""
#    java_files = []
#    for root, _, files in os.walk(test_directory):
#        for file in files:
#            if file.endswith(".java"):
#                java_files.append(os.path.join(root, file))
#    return java_files
#
#def extract_package_and_class_name(java_file):
#    """Extract the package and class name from a Java file."""
#    package_name = None
#    class_name = None
#    with open(java_file, 'r', encoding='utf-8') as file:
#        content = file.read()
#        package_match = re.search(r'^\s*package\s+([\w\.]+);', content, re.MULTILINE)
#        if package_match:
#            package_name = package_match.group(1)
#        class_match = re.search(r'^\s*public\s+class\s+(\w+)', content, re.MULTILINE)
#        if class_match:
#            class_name = class_match.group(1)
#    return package_name, class_name
#
#def extract_test_methods(file_path, package_name, class_name):
#    """Extract individual test methods with their full content."""
#    test_methods = []
#    with open(file_path, 'r', encoding='utf-8') as file:
#        code = file.read()
#    
#    # Match @Test and the method body
#    method_pattern = r'(@Test[\s\S]*?)(public|private|protected)?\s+[\w<>]+\s+([\w]+)\s*\([\s\S]*?\)\s*\{'
#    matches = re.finditer(method_pattern, code)
#
#    for match in matches:
#        full_declaration = match.group(0)  # Declaration + start of body
#        method_name = match.group(3)
#        start_index = match.end() - 1  # Start after the opening brace
#
#        # Extract the full method body using braces
#        full_body = extract_full_body(code, start_index)
#        if full_body:
#            full_code = full_declaration + full_body  # Combine declaration and body
#            if package_name and class_name:
#                test_full_path = f"{package_name}.{class_name}.{method_name}"
#                test_methods.append((test_full_path, full_code))
#    
#    return test_methods
#
#def extract_full_body(content, start_index):
#    """Extract the full body of a method, accounting for nested braces."""
#    brace_count = 0
#    method_body = []
#    inside_method = False
#
#    for i in range(start_index, len(content)):
#        char = content[i]
#
#        if char == '{':
#            brace_count += 1
#            inside_method = True
#
#        if inside_method:
#            method_body.append(char)
#
#        if char == '}':
#            brace_count -= 1
#            if brace_count == 0:
#                # Found the matching closing brace for the method
#                break
#
#    if brace_count == 0:
#        return ''.join(method_body)
#    else:
#        # If braces are not balanced, return None
#        return None
#
#def main(test_directory, output_csv, proj_name):
#    """Main function to find all test methods in a Maven test directory."""
#    java_files = find_java_files(test_directory)
#    all_test_methods = []
#    count_id = 0
#
#    for java_file in java_files:
#        package_name, class_name = extract_package_and_class_name(java_file)
#        test_methods = extract_test_methods(java_file, package_name, class_name)
#
#        for test_full_path, full_code in test_methods:
#            count_id += 1
#            all_test_methods.append((count_id, proj_name, test_full_path, full_code))
#
#    # Write to CSV
#    with open(output_csv, 'w', newline='', encoding='utf-8') as csvfile:
#        writer = csv.writer(csvfile)
#        writer.writerow(['id', 'proj_name', 'test_full_path', 'full_code'])
#        writer.writerows(all_test_methods)
#
#    print(f"Extracted test methods have been saved to {output_csv}")
#
#if __name__ == "__main__":
#    # Change this path to your Maven test directory
#    test_directory = sys.argv[1]
#    proj_name = sys.argv[2]
#    output_csv = proj_name + "_test_methods.csv"
#    main(test_directory, output_csv, proj_name)
#
import os
import re
import csv
import sys

def find_java_files(test_directory):
    """Find all Java files in the given directory recursively."""
    java_files = []
    for root, _, files in os.walk(test_directory):
        for file in files:
            if file.endswith(".java"):
                java_files.append(os.path.join(root, file))
    return java_files

def extract_package_and_class_name(java_file):
    """Extract the package and class name from a Java file."""
    package_name = None
    class_name = None
    with open(java_file, 'r', encoding='utf-8') as file:
        content = file.read()
        package_match = re.search(r'^\s*package\s+([\w\.]+);', content, re.MULTILINE)
        if package_match:
            package_name = package_match.group(1)
        class_match = re.search(r'^\s*public\s+class\s+(\w+)', content, re.MULTILINE)
        if class_match:
            class_name = class_match.group(1)
    return package_name, class_name

def extract_test_methods(file_path, package_name, class_name):
    """Extract individual test methods with their full content."""
    test_methods = []
    with open(file_path, 'r', encoding='utf-8') as file:
        code = file.read()
    
    # Match @Test and the method body
    method_pattern = r'(@Test[\s\S]*?)(public|private|protected)?\s+\w+\s+([\w]+)\s*\([\s\S]*?\)\s*\{'
    matches = re.finditer(method_pattern, code)

    for match in matches:
        declaration = match.group(0)  # Declaration + start of body
        method_name = match.group(3)
        start_index = match.end() - 1  # Start after the opening brace

        # Extract the full method body using braces
        method_body = extract_full_body(code, start_index)
        if method_body:
            full_code = declaration + method_body  # Combine declaration and body
            test_full_path = f"{package_name}.{class_name}.{method_name}"
            test_methods.append((test_full_path, full_code))
    
    return test_methods

def extract_full_body(content, start_index):
    """Extract the full body of a method, accounting for nested braces."""
    brace_count = 0
    method_body = []
    inside_method = False

    for i in range(start_index, len(content)):
        char = content[i]

        if char == '{':
            brace_count += 1
            inside_method = True

        if inside_method:
            method_body.append(char)

        if char == '}':
            brace_count -= 1
            if brace_count == 0:
                # Found the matching closing brace for the method
                break

    if brace_count == 0:
        return ''.join(method_body)
    else:
        # If braces are not balanced, return None
        return None

def main(test_directory, output_csv, proj_name):
    """Main function to find all test methods in a Maven test directory."""
    java_files = find_java_files(test_directory)
    all_test_methods = []
    count_id = 0

    for java_file in java_files:
        package_name, class_name = extract_package_and_class_name(java_file)
        if not package_name or not class_name:
            continue  # Skip files without package or class name

        test_methods = extract_test_methods(java_file, package_name, class_name)

        for test_full_path, full_code in test_methods:
            count_id += 1
            all_test_methods.append((count_id, proj_name, test_full_path, full_code))

    # Write to CSV
    with open(output_csv, 'w', newline='', encoding='utf-8') as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow(['id', 'proj_name', 'test_full_path', 'full_code'])
        writer.writerows(all_test_methods)

    print(f"Extracted test methods have been saved to {output_csv}")

if __name__ == "__main__":
    # Change this path to your Maven test directory
    test_directory = sys.argv[1]
    proj_name = sys.argv[2]
    output_csv = proj_name + "_test_methods.csv"
    main(test_directory, output_csv, proj_name)

