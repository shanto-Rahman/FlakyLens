#import re
#from collections import defaultdict
#
#def parse_file(filename):
#    """Extracts tokens for each category from the given file."""
#    category_tokens = defaultdict(set)  # Using set to store unique tokens
#    
#    with open(filename, 'r', encoding='utf-8') as file:
#        category = None
#        for line in file:
#            line = line.strip()
#            
#            # Match category lines (e.g., "Category 0:")
#            category_match = re.match(r'Category (\d+):', line)
#            if category_match:
#                category = int(category_match.group(1))
#                continue
#            
#            # Match token lines (e.g., "- wait: 82")
#            token_match = re.match(r'- ([\w\d\.\-]+): \d+', line)
#            if token_match and category is not None:
#                token = token_match.group(1)
#                category_tokens[category].add(token)
#
#    return category_tokens
#
#def find_common_tokens(file1, file2):
#    """Finds common tokens between two files category-wise."""
#    tokens_1 = parse_file(file1)
#    tokens_2 = parse_file(file2)
#
#    common_tokens = {}
#    for category in set(tokens_1.keys()).intersection(set(tokens_2.keys())):
#        common_tokens[category] = tokens_1[category].intersection(tokens_2[category])
#
#    return common_tokens
#
## Example usage:
#file1 = "qwen.txt"
#file2 = "llama_3_8b.txt"
#
#common_tokens = find_common_tokens(file1, file2)
#
## Print results category-wise
#print("\nCommon Tokens Per Category:")
#for category, tokens in common_tokens.items():
#    print(f"Category {category}: {sorted(tokens)}")
#
import re
from collections import defaultdict

def parse_file(filename):
    """Extracts tokens for each category from the given file."""
    category_tokens = defaultdict(set)  # Using set to store unique tokens
    
    with open(filename, 'r', encoding='utf-8') as file:
        category = None
        for line in file:
            line = line.strip()
            
            # Match category lines (e.g., "Category 0:")
            category_match = re.match(r'Category (\d+):', line)
            if category_match:
                category = int(category_match.group(1))
                continue
            
            # Match token lines (e.g., "- wait: 82")
            token_match = re.match(r'- ([\w\d\.\-]+): \d+', line)
            if token_match and category is not None:
                token = token_match.group(1)
                category_tokens[category].add(token)

    return category_tokens

def find_common_tokens(files):
    """Finds common tokens across multiple files category-wise."""
    parsed_data = [parse_file(file) for file in files]

    common_tokens = defaultdict(set)
    all_categories = set(cat for data in parsed_data for cat in data.keys())

    for category in all_categories:
        # Intersect tokens across all files for this category
        common_set = set.intersection(*[data.get(category, set()) for data in parsed_data])
        if common_set:
            common_tokens[category] = common_set

    return common_tokens

# Example usage: Provide a list of text files
#files = ["qwen.txt", "llama_3_8b.txt", "codegemma-7b.txt", "codellama-13b.txt", "deep_seek_coder.txt", "gemma7b.txt"]
files = ["llama_3_8b.txt", "deep_seek_coder.txt"]

common_tokens = find_common_tokens(files)

# Print results category-wise
print("\nCommon Tokens Per Category Across All Files:")
for category, tokens in common_tokens.items():
    print(f"Category {category}: {sorted(tokens)}")

