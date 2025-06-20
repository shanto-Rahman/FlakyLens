@Test public void should_return_existing_duplicates(){
assertEquals(3,sizeOf(duplicates));
assertTrue(caseInsensitiveComparisonStrategy.iterableContains(duplicates,"frodo"));
assertTrue(caseInsensitiveComparisonStrategy.iterableContains(duplicates,"MERRY"));
assertTrue(caseInsensitiveComparisonStrategy.iterableContains(duplicates,null));
}