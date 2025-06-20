if [[ $1 == "" ]]; then
    echo "GIVE the datafile (e.g.,IDOFT/Flakify_IDoFT_dataset.csv)"
    exit
fi

count=0
rm "test_name.csv"
echo "test_case_name,category" >> "test_name.csv"
while read line
do
    #echo "line=$line"
    firstChar=${line:0:1}
    if [[ $firstChar =~ ^[0-9]+$ ]]; then # Because I am assuming every line starts with the sha and the beginning of sha is a number
        echo "This is a Number"
        #echo $line
        if [[ $count -gt 0 ]]; then
            id=$(echo $line | cut -d',' -f1)
            testName=$(echo $line | cut -d',' -f1 | cut -d'.' -f2 | sed 's;-;.;g')
            echo $testName
            row=$(grep -r "$testName" "pr-data.csv")
            
            if [[ $row == "" ]]; then
                echo "$id,0" >> "test_name.csv"
            else
                category=$(echo $row | cut -d',' -f5) #Labeling of OD/NOD/NDOD/UD....
				if [[ $category == "NDOD" ]]; then
                    echo "$id,1" >> "test_name.csv" 
                elif [[ $category == "NOD" ]]; then
                    echo "$id,2" >> "test_name.csv" 
                elif [[ $category == "OD" ]]; then
                    echo "$id,3" >> "test_name.csv" 
                elif [[ $category == "ID" ]]; then
                    echo "$id,4" >> "test_name.csv" 
                elif [[ $category == "NIO" ]]; then
                    echo "$id,5" >> "test_name.csv" 
                elif [[ $category == "UD" ]]; then
                    echo "$id,6" >> "test_name.csv" 
               fi  
            #echo $category #OD=1,NOD=2,ID=3,NIO=4,UD=5,NDOD=6
            #exit
            fi
            count=$((count + 1))
        else
            count=$((count + 1))
        fi
    else
        echo "$line" >> "Not_a_test.txt"
        #echo "This is NOT a Number"
    fi

    #if [[ $count -gt 2 ]];then
    #    exit
    #fi
done < $1
