import csv
import re
import sys

def indent_java_code(code):
    """
    Apply basic indentation to the Java code.
    This function handles block-based indentation for curly braces.
    """
    indent_level = 0
    indent_size = 4
    indented_code = []
    for line in code.splitlines():
        stripped_line = line.strip()

        # Adjust indentation for closing braces
        if stripped_line.endswith('}') or stripped_line.startswith('}'):
            indent_level -= 1

        # Apply indentation
        indented_code.append((' ' * (indent_level * indent_size)) + stripped_line)

        # Adjust indentation for opening braces
        if stripped_line.endswith('{'):
            indent_level += 1

    return '\n'.join(indented_code)


def process_csv(input_csv, output_csv):
    with open(input_csv, mode='r') as infile, open(output_csv, mode='w', newline='') as outfile:
        reader = csv.DictReader(infile)
        fieldnames = reader.fieldnames
        writer = csv.DictWriter(outfile, fieldnames=fieldnames)

        # Write header
        writer.writeheader()

        # Process each row
        for row in reader:
            if 'full_code' in row:
                # Apply indentation to the 'full_code' column
                original_code = row['full_code']
                indented_code = indent_java_code(original_code)
                row['full_code'] = indented_code

            # Write updated row
            writer.writerow(row)

if __name__ == "__main__":
    input_csv = sys.argv[1] #"Flakicat_dataset.csv"  # Replace with your file path
    output_csv = "Flakicat_dataset_with_nonflaky_indented.csv"
    process_csv(input_csv, output_csv)
    print(f"Indented Java code saved to {output_csv}")

