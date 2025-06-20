@Test public void testFindAndSetAttributesResourceInstance(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.RESOURCE,dependency.getDependencyType());
assertEquals("ResourceCollector",dependency.getJavaSourceFrom().getName());
assertEquals("TimerService",dependency.getJavaSourceTo().getName());
}