import pandas as pd
import sys
from collections import Counter

def parse_fold(contents):
    fold_data = {}
    for line in contents:
        parts = line.strip().split(":")
        fold_number = parts[0].strip()
        numbers = [int(num) for num in parts[1].split(",")]
        fold_data[fold_number] = numbers
    return fold_data

if __name__ == "__main__":
    file1 = sys.argv[1] #without_perturbation
    file2 = sys.argv[2]
    with open(file1, "r") as file:
        file1_contents = file.readlines()
    
    with open(file2, "r") as file:
        file2_contents = file.readlines()

    fold_data1 = parse_fold(file1_contents)
    print(fold_data1)
    fold_data2 = parse_fold(file2_contents)
    print(fold_data2)
	# Compare folds and identify changes
    for fold, data1 in fold_data1.items():

        data2 = fold_data2.get(fold)
        #print(data2)
        changes = [(data1[i], data2[i]) for i in range(min(len(data1), len(data2))) if data1[i] != data2[i]]
        pair_counts = Counter(changes)
        print('changes=',str(changes))
        with open("frequency_count_of_pairs.txt", "a") as f:
            f.write(f"Fold: {fold}\n")
            print('fold=',str(fold))
            for pair, count in pair_counts.items():
                print(pair)
                f.write(f"Pair {pair}: {count} times\n")
