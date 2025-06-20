@Test public void testGetRelevantClassesDirectlyConnected(){
  DependencyFilter filter=new DependencyFilter().addType(DependencyType.PRODUCES).addType(DependencyType.INSTANCE).setDirectlyConnected(true);
  TestDataProvider.createSampleDependencies();
  assertEquals(9,DependencyContainer.getInstance().getFilteredJavaSources(filter).size());
}
