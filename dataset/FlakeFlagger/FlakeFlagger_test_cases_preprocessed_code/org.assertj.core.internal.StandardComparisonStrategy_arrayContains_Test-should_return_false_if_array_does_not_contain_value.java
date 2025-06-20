@Test public void should_return_false_if_array_does_not_contain_value(){
assertFalse(standardComparisonStrategy.arrayContains(hobbits,"Pippin"));
assertFalse(standardComparisonStrategy.arrayContains(hobbits,"SAM "));
assertFalse(standardComparisonStrategy.arrayContains(hobbits,null));
}