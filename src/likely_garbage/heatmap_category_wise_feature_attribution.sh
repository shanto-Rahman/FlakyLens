dataset_name="Flakicat_category"
#category_array=(4 5)
#attribution_dir="attributions_without_perturbation/"
#attribution_dir="attributions_deadcode_perturbation/"
#attribution_dir="attributions_printStatement_perturbation/"
#attribution_dir="attributions_variableDeclare_perturbation/"
#attribution_dir="attributions_multiLine_comment_perturbation/"
#attribution_dir="attributions_singleLine_comment_perturbation/"
attributions=("attributions_without_perturbation/") # "attributions_deadcode_perturbation/" "attributions_printStatement_perturbation/"  "attributions_variableDeclare_perturbation/" "attributions_multiLine_comment_perturbation/")
#attributions=("attributions_without_perturbation/")
#"attributions_deadcode_perturbation/" "attributions_printStatement_perturbation/"  "attributions_variableDeclare_perturbation/" "attributions_multiLine_comment_perturbation/")
# "attributions_singleLine_comment_perturbation/"

category_array=(3)
#category_array=(0 1 2 3 4 5)
feature_grp="most_important_features"
#feature_grp="least_important_features"
for attribution_dir in "${attributions[@]}"; do
    for category in ${category_array[@]}; do
        category_in_file="\[${category}\]"
        files="${dataset_name}_"${category}"*.csv"
        all_files=$(find "${attribution_dir}detokenization/" -name $files)
        #echo $all_files
        #echo "Token,Attribution,Predicted_class,True_class,Pred_logit" > "tmp_${category}"
        #for file in $all_files; do
            #grep ",${category_in_file}" $file >> "tmp_${category}"
        python3 heatmap_category_wise_feature_attribution.py "${attribution_dir}detokenization/${dataset_name}_${category}_${feature_grp}.csv" "${attribution_dir}detokenization/heatmaps/${dataset_name}_${category}_${feature_grp}.png" $category $dataset_name $attribution_dir $feature_grp
        #done 
        #exit
    done
done
