@Test public void should_return_true_if_array_contains_value(){
assertTrue(standardComparisonStrategy.arrayContains(hobbits,"Sam"));
assertTrue(standardComparisonStrategy.arrayContains(hobbits,"Merry"));
assertTrue(standardComparisonStrategy.arrayContains(hobbits,null));
}