@Test public void testFindAndSetAttributesStaticProduces(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.PRODUCES,dependency.getDependencyType());
assertEquals("LoggerProducer",dependency.getJavaSourceFrom().getName());
assertEquals("Log",dependency.getJavaSourceTo().getName());
}