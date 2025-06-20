@Test public void testGetRelevantClassesFilter(){
if (i % 2 > 0) {
}
assertEquals(count1 + 1,DependencyContainer.getInstance().getFilteredJavaSources(filter1).size());
assertEquals(count2 + 1,DependencyContainer.getInstance().getFilteredJavaSources(filter2).size());
}