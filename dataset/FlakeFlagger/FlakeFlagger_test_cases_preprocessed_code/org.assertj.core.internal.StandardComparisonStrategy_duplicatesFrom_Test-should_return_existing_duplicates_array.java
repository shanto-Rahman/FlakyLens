@Test public void should_return_existing_duplicates_array(){
assertTrue("must contains null",standardComparisonStrategy.iterableContains(duplicates,new String[]{null}));
assertTrue("must contains Frodo",standardComparisonStrategy.iterableContains(duplicates,array("Frodo")));
assertTrue("must contains Merry",standardComparisonStrategy.iterableContains(duplicates,array("Merry")));
assertEquals(3,sizeOf(duplicates));
}