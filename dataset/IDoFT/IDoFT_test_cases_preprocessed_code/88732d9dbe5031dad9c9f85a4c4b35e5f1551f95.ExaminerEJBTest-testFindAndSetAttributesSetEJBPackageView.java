@Test public void testFindAndSetAttributesSetEJBPackageView(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.EJB,dependency.getDependencyType());
assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
assertEquals("PersonSessionBean",dependency.getJavaSourceTo().getName());
}