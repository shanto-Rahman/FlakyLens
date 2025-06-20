#!/bin/bash
#$1=all_idoft_uniq_project.csv
while read line
do
    #occurance=$(grep -r "$line," "data_distribution.csv" | wc -l)
    occurance=$(grep "^$line," data_distribution.csv | wc -l)
    echo "$line,$occurance" >> "per_project_data_distribution.csv"
done < $1

