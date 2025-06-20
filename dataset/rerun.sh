#$1=Total-tests.csv
currentDir=$(pwd)
outputDir="Result-Time.csv"
inputProj=$currentDir"/projects-For-Delta"
if [ ! -d "projects-For-Delta" ] 
then
    mkdir ${inputProj}
fi

while IFS= read -r line
    do
    if [[ ${line} =~ ^\# ]]; then
        echo "Line starts with Hash $line"
        continue
    fi
    slug=$(echo $line | cut -d',' -f1)
    sha=$(echo $line | cut -d',' -f2)
    module=$(echo $line | cut -d',' -f3)
    testName=$(echo $line | cut -d',' -f4)
    rootProj=$(echo "$slug" | cut -d/ -f 1)
    subProj=$(echo "$slug" | cut -d/ -f 2)

    if [[ ! -d ${inputProj}/${rootProj} ]]; then
        git clone "https://github.com/$slug" $inputProj/$slug
    fi
    
    cd $inputProj/$slug
    git checkout ${sha}

    if [[ "$slug" == "doanduyhai/Achilles" ]]; then
        sed -i 's~http://repo1.maven.org/maven2~https://repo1.maven.org/maven2~g' pom.xml
    else
        echo "Strings are not equal."
    fi  

    echo -n "${slug}" >> "$currentDir/$outputDir"
    echo -n ",${sha}" >> "$currentDir/$outputDir"
    echo -n ",${module}" >> "$currentDir/$outputDir"
    echo -n ",${testName}" >> "$currentDir/$outputDir"
    mvn clean install -pl $module -am  -DskipTests
    start=$(date +%s.%N)
    mvn test -pl $module -Dtest=$testName
    end=$(date +%s.%N)
    take=$(echo "scale=2; ${end} - ${start}" | bc)
    echo ",$take" >> "$currentDir/$outputDir"
    cd $currentDir
    rm -rf $inputProj/$rootProj
done < $1
