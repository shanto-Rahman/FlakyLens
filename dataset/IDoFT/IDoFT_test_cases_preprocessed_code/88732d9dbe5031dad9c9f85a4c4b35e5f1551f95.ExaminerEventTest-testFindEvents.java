@Test public void testFindEvents(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.EVENT,dependency.getDependencyType());
assertEquals("Events",dependency.getJavaSourceFrom().getName());
assertEquals("AirEvent",dependency.getJavaSourceTo().getName());
}