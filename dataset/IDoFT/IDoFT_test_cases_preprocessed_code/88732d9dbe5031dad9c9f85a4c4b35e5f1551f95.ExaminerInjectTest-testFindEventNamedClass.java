@Test public void testFindEventNamedClass(){
assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.INJECT,dependency.getDependencyType());
assertEquals("Events",dependency.getJavaSourceFrom().getName());
assertEquals("EventValidator",dependency.getJavaSourceTo().getName());
assertEquals(DependencyType.INJECT,dependency.getDependencyType());
assertEquals("Events",dependency.getJavaSourceFrom().getName());
assertEquals("PrintingService",dependency.getJavaSourceTo().getName());
}