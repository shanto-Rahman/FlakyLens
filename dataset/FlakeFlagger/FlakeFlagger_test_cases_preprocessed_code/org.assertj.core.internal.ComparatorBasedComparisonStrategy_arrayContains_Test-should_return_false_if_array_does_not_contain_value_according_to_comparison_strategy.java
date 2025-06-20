@Test public void should_return_false_if_array_does_not_contain_value_according_to_comparison_strategy(){
assertFalse(caseInsensitiveComparisonStrategy.arrayContains(hobbits,"Pippin"));
assertFalse(caseInsensitiveComparisonStrategy.arrayContains(hobbits,"Sam  "));
}