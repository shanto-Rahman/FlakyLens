@Test public void testAddJavaSourceDoublette(){
assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName(name));
assertEquals(1,JavaSourceContainer.getInstance().getJavaSources().size());
assertEquals(name,JavaSourceContainer.getInstance().getJavaSourceByName(name).getName());
assertEquals(sourceCode1,JavaSourceContainer.getInstance().getJavaSourceByName(name).getSourceCode());
}