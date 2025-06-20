import pandas as pd
import csv 
df = pd.read_csv('IDoFT/Flakify_IDoFT_dataset-main.csv')
column=df['test_case_name']
uniq_Id=[]
column_header=["test_case_name", "project", "category"]
header=0
# iterate over the values in the DataFrame
for index, row in df.iterrows():
    # get the value you want to search for in the other CSV file
    Id = row['test_case_name']
    project_name = row['project']
    if Id not in uniq_Id:
        uniq_Id.append(Id)
        split_string = Id.split(".")
        classname_testname = split_string[1]
        value_to_search=classname_testname.replace("-",".")
        
        # read the other CSV file
        df2 = pd.read_csv('pr-data.csv')
        
        # search for matching values in the other CSV file
        matching_rows = df2[df2['Fully-Qualified Test Name (packageName.ClassName.methodName)'].str.contains(value_to_search)]
        #print(matching_rows)
        '''if matching_rows.empty:                
            #print("Matching dataframe is empty")
            res=[Id,"6"]
        else:'''
        category = matching_rows.loc[:, 'Category'].to_string()
        res=""
        if "NDOD" in category:
            res=[Id, project_name, "0"]
        elif "NOD" in category:
            res=[Id, project_name,"1"]
        elif "OD" in category:
            res=[Id, project_name,"2"]
        elif "ID" in category:
            res=[Id, project_name, "3"]
        elif "NIO" in category:
            res=[Id, project_name ,"4"]
        elif "UD" in category:
            res=[Id, project_name, "5"]
        #print(res)
        with open('test_name_from_py.csv','a',newline='') as csvfile:
            writer=csv.writer(csvfile)
            if header == 0:
                writer.writerow(column_header)
                header=1
            else:
                writer.writerow(res)
    else:
        print('duplicate'+Id)
    #break
#column.to_csv('one_col.csv',index=False)

