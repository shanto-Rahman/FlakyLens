import sys

def parse_line(line):
    """Parses a line of integers separated by commas after a colon."""
    return list(map(int, line.split(':')[1].strip().split(',')))

def process_fold(original, fold):
    """Calculates and returns the transformation frequency from original to fold results."""
    transformations = {}
    for orig, pred in zip(original, fold):
        if orig != pred:
            pair = (orig, pred)
            transformations[pair] = transformations.get(pair, 0) + 1
    return transformations

def main():
    # Replace 'your_file.txt' with your actual file path
    filename = sys.argv[1] #'Flakicat_Categorization-result/deadcode_perturbation.txt'
    results = []
    
    with open(filename, 'r') as file:
        lines = file.readlines()
    
    # Process the file in chunks of two lines
    for i in range(0, len(lines), 2):
        if i+1 < len(lines):  # Check if there's a pair of lines to process
            original_line = lines[i].strip()
            fold_line = lines[i+1].strip()
            if original_line.startswith("Original") and fold_line.startswith("Fold"):
                original = parse_line(original_line)
                fold = parse_line(fold_line)
                fold_name = fold_line.split(':')[0].strip()
                transformations = process_fold(original, fold)
                results.append((fold_name, transformations))
    
    # Print results
    for fold_name, trans in results:
        print(f"Results for {fold_name}:")
        for pair, count in trans.items():
            print(f"Pair {pair}: {count} times")

if __name__ == "__main__":
    main()
