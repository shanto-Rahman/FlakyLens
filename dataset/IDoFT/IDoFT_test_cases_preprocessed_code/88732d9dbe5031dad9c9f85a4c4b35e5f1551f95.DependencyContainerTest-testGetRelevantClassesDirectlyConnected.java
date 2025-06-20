@Test public void testGetRelevantClassesDirectlyConnected(){
assertEquals(9,DependencyContainer.getInstance().getFilteredJavaSources(filter).size());
}