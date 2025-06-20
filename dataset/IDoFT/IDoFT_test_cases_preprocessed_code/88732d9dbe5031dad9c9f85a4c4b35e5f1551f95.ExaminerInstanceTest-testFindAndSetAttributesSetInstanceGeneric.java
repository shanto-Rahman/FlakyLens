@Test public void testFindAndSetAttributesSetInstanceGeneric(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.INSTANCE,dependency.getDependencyType());
assertEquals("SnapshotProvider",dependency.getJavaSourceFrom().getName());
assertEquals("DataCollector",dependency.getJavaSourceTo().getName());
}