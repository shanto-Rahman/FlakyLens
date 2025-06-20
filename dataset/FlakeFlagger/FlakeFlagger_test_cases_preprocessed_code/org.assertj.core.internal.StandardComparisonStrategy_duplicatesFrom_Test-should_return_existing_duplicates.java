@Test public void should_return_existing_duplicates(){
assertEquals(3,sizeOf(duplicates));
assertTrue(standardComparisonStrategy.iterableContains(duplicates,"Frodo"));
assertTrue(standardComparisonStrategy.iterableContains(duplicates,"Merry"));
assertTrue(standardComparisonStrategy.iterableContains(duplicates,null));
}