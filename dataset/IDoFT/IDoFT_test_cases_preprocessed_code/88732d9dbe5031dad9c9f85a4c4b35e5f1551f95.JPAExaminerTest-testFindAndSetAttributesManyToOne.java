@Test public void testFindAndSetAttributesManyToOne(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.MANY_TO_ONE,dependency.getDependencyType());
assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
assertEquals("Album",dependency.getJavaSourceTo().getName());
}