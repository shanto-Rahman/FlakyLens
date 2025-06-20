@Test public void testGetJavaSourceByName(){
  JavaSourceContainer.getInstance().clear();
  JavaSource javaSource1=JavaSourceFactory.getInstance().newJavaSource("DataPoint");
  JavaSourceContainer.getInstance().add(javaSource1);
  JavaSource javaSource2=JavaSourceFactory.getInstance().newJavaSource("int");
  JavaSourceContainer.getInstance().add(javaSource2);
  JavaSource javaSource3=JavaSourceFactory.getInstance().newJavaSource("MyTestClass");
  JavaSourceContainer.getInstance().add(javaSource3);
  assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName("MyTestClass"));
  assertEquals("MyTestClass",JavaSourceContainer.getInstance().getJavaSourceByName("MyTestClass").getName());
  assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName("int"));
  assertEquals("int",JavaSourceContainer.getInstance().getJavaSourceByName("int").getName());
  assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName("DataPoint"));
  assertEquals("DataPoint",JavaSourceContainer.getInstance().getJavaSourceByName("DataPoint").getName());
}
