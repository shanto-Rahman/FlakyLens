@Test public void testAddJavaSourceDoublette(){
  JavaSourceContainer.getInstance().clear();
  String name="DataPoint";
  JavaSource javaSource1=JavaSourceFactory.getInstance().newJavaSource(name);
  String sourceCode1="Test source code for JavaSource1 (listen to Brian Blade - Season of change";
  javaSource1.setSourceCode(sourceCode1);
  JavaSourceContainer.getInstance().add(javaSource1);
  JavaSource javaSource2=JavaSourceFactory.getInstance().newJavaSource(name);
  javaSource2.setSourceCode("");
  JavaSourceContainer.getInstance().add(javaSource2);
  assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName(name));
  assertEquals(1,JavaSourceContainer.getInstance().getJavaSources().size());
  assertEquals(name,JavaSourceContainer.getInstance().getJavaSourceByName(name).getName());
  assertEquals(sourceCode1,JavaSourceContainer.getInstance().getJavaSourceByName(name).getSourceCode());
}
