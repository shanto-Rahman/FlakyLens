@Test public void testBuildJSONLinks(){
  TestDataProvider.createSampleDependencies();
  JsonArray links=GraphCreator.buildJSONLinks(null).build();
  assertEquals(12,links.size());
  DependencyFilter filter=new DependencyFilter().addType(DependencyType.PRODUCES).addType(DependencyType.INSTANCE).setDirectlyConnected(true);
  links=GraphCreator.buildJSONLinks(filter).build();
  assertEquals(8,links.size());
}
