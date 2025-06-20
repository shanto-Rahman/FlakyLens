@Test public void should_not_remove_value_from_collections_since_it_does_not_match_any_collections_elements_according_to_given_comparator(){
assertTrue(caseInsensitiveComparisonStrategy.iterableContains(hobbits,"SAM"));
assertTrue(caseInsensitiveComparisonStrategy.iterableContains(hobbits,"SAM"));
}