pyhton3 collect-label.py IDoFT/Flakify_IDoFT_dataset.csv

python3 append_catgory_with_master_dataset.py test_name_from_py.csv

bash data-distribution.sh all_idoft_uniq_project.csv

#To sort based on the 2nd column
sort -t',' -k2r per_project_data_distribution.csv > out

python3 find_all_test_name_and_body.py New_Proj/Java-WebSocket/src/test/java/




First we look for the commit for each project available in the Flakicat/Flakicat_dataset_with_nonflaky_indented.csv

find_commit_for_proj.sh 
This outputs filtered_tests_with_sha.csv

Then using filtered_tests_with_sha.csv, we look for the owner for each project available in the Flakicat/Flakicat_dataset_with_nonflaky_indented.csv

bash find_owner_for_proj.sh 

Then we clone projects and do the checkout
bash clone_proj_and_checkout.sh

bash stratified_selection_of_tests.sh
