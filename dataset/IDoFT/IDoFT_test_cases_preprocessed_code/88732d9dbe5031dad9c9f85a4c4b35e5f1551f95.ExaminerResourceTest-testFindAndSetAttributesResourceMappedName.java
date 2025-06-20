@Test public void testFindAndSetAttributesResourceMappedName(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.RESOURCE,dependency.getDependencyType());
assertEquals("SimplifiedMessageReceiver",dependency.getJavaSourceFrom().getName());
assertEquals("Queue",dependency.getJavaSourceTo().getName());
}