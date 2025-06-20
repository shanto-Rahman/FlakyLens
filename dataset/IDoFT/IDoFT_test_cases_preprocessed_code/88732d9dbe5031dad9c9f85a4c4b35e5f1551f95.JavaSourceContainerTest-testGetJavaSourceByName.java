@Test public void testGetJavaSourceByName(){
assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName("MyTestClass"));
assertEquals("MyTestClass",JavaSourceContainer.getInstance().getJavaSourceByName("MyTestClass").getName());
assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName("int"));
assertEquals("int",JavaSourceContainer.getInstance().getJavaSourceByName("int").getName());
assertNotNull(JavaSourceContainer.getInstance().getJavaSourceByName("DataPoint"));
assertEquals("DataPoint",JavaSourceContainer.getInstance().getJavaSourceByName("DataPoint").getName());
}