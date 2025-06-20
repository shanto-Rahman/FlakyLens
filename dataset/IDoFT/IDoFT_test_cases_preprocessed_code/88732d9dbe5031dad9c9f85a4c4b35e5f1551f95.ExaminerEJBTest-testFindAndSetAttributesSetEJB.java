@Test public void testFindAndSetAttributesSetEJB(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.EJB,dependency.getDependencyType());
assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
assertEquals("EntityManager",dependency.getJavaSourceTo().getName());
}