@Test public void should_fail_if_actual_contains_given_values_according_to_custom_comparison_strategy(){
iterablesWithCaseInsensitiveComparisonStrategy.assertDoesNotContain(info,actual,expected);//RW
verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet("LuKe","YODA"),comparisonStrategy));//RW
}