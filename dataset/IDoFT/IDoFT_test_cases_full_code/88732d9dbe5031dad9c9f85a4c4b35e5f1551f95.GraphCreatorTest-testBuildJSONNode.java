@Test public void testBuildJSONNode(){
  JavaSourceContainer.getInstance().clear();
  DependencyContainer.getInstance().clear();
  String name="MyTestClass";
  String sourcecode="test source code - Matt Pavolka Group - Something People Can Use";
  JavaSource javaSource=JavaSourceFactory.getInstance().newJavaSource("MyTestClass");
  javaSource.setGroup(2);
  javaSource.setPackagePath("de.test.test2");
  javaSource.setSourceCode(sourcecode);
  JsonObjectBuilder job=GraphCreator.buildJSONNode(javaSource);
  JsonObject node=job.build();
  assertEquals(name,node.getString("name"));
  assertEquals(2,node.getInt("group"));
  assertNotNull(node.getString("description"));
  assertEquals(sourcecode,node.getString("sourcecode"));
}
