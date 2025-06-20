@Test public void should_fail_if_actual_contains_value_at_index_according_to_custom_comparison_strategy(){
listsWithCaseInsensitiveComparisonStrategy.assertDoesNotContain(info,actual,"YODA",index);//RW
verify(failures).failure(info,shouldNotContainAtIndex(actual,"YODA",index,comparisonStrategy));//RW
}