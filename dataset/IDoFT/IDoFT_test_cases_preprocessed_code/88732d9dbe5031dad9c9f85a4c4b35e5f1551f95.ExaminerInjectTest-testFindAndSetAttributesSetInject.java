@Test public void testFindAndSetAttributesSetInject(){
assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.INJECT,dependency.getDependencyType());
assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
assertEquals("TestClass",dependency.getJavaSourceTo().getName());
assertEquals(DependencyType.INJECT,dependency.getDependencyType());
assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
assertEquals("EntityManager",dependency.getJavaSourceTo().getName());
}