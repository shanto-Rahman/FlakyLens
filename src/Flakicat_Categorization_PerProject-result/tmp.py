import pandas as pd
import sys

filename = sys.argv[1]
df = pd.read_csv(filename)
print(len(df))
