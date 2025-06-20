@Test public void testBuildJSONNodes(){
  JavaSourceContainer.getInstance().clear();
  int count=10;
  String namePrefix="Testclass ";
  for (int i=0; i < count; i++) {
    String name=namePrefix + i;
    JavaSource javaSource=JavaSourceFactory.getInstance().newJavaSource(name);
    JavaSourceContainer.getInstance().add(javaSource);
  }
  JsonArray nodes=GraphCreator.buildJSONNodes(null).build();
  assertEquals(count,nodes.size());
}
