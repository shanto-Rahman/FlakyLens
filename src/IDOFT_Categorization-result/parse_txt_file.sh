#$1=DT_classification_report.txt
grep '^\s*[0-5]' $1 > X
sort X > tmp
sed 's/\s\+/,/g' tmp > X

#For 1st 10 rows
head -n 10 X > tmp
total_support=0
total_mul=0
while read line 
do
    f1_score=$(echo $line | cut -d',' -f5) 
    support=$(echo $line | cut -d',' -f6) 
    total_support=$(echo $total_support + $support | bc)
    mul=$(echo $f1_score*$support | bc)
    echo $mul
    total_mul=$(echo $total_mul + $mul | bc)
done  < tmp
echo $total_support
echo $total_mul
avg_f_score=$(echo "scale=3; $total_mul / $total_support" | bc)
echo -n "$1",$avg_f_score >> "Res.csv"

#exit
for i in {1..5}; do
    start=$(($i*10 + 1))
    echo $start
    tail -n +$start X | head -n 10 > tmp

    total_support=0
    total_mul=0
    while read line 
    do
        f1_score=$(echo $line | cut -d',' -f5) 
        support=$(echo $line | cut -d',' -f6) 
        total_support=$(echo $total_support + $support | bc)
        mul=$(echo $f1_score*$support | bc)
        echo $mul
        total_mul=$(echo $total_mul + $mul | bc)
    done  < tmp
    echo $total_support
    echo $total_mul
    avg_f_score=$(echo "scale=3; $total_mul / $total_support" | bc)
    echo -n ",$avg_f_score" >> "Res.csv"
#    exit
done
echo  "" >> "Res.csv"

