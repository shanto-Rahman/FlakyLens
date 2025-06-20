@Test public void testFindAndSetAttributesProduces(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.PRODUCES,dependency.getDependencyType());
assertEquals("DatabaseProducer",dependency.getJavaSourceFrom().getName());
assertEquals("EntityManager",dependency.getJavaSourceTo().getName());
}