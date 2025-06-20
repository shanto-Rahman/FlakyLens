@Test public void should_remove_value_from_collections_since_it_matches_one_collections_element_according_to_given_comparator(){
assertTrue(caseInsensitiveComparisonStrategy.iterableContains(hobbits,"SAM"));
assertFalse(caseInsensitiveComparisonStrategy.iterableContains(hobbits,"SAM"));
assertFalse(caseInsensitiveComparisonStrategy.iterableContains(hobbits,null));
}