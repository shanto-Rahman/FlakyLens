@Test public void should_fail_if_actual_does_not_contain_value_at_index_according_to_custom_comparison_strategy(){
listsWithCaseInsensitiveComparisonStrategy.assertContains(info,actual,"Han",index);//RW
verify(failures).failure(info,shouldContainAtIndex(actual,"Han",index,"Luke",comparisonStrategy));//RW
}