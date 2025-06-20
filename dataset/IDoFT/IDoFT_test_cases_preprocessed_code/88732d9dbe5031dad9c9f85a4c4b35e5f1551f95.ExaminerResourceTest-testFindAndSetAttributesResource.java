@Test public void testFindAndSetAttributesResource(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.RESOURCE,dependency.getDependencyType());
assertEquals("DatabaseConnectionProducer",dependency.getJavaSourceFrom().getName());
assertEquals("DataSource",dependency.getJavaSourceTo().getName());
}