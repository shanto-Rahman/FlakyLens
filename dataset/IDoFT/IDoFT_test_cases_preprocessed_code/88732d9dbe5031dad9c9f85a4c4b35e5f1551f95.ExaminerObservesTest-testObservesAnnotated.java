@Test public void testObservesAnnotated(){
assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.OBSERVES,dependency1.getDependencyType());
assertEquals("SnapshotEscalator",dependency1.getJavaSourceFrom().getName());
assertEquals("BrowserWindow",dependency1.getJavaSourceTo().getName());
assertEquals(DependencyType.OBSERVES,dependency2.getDependencyType());
assertEquals("SnapshotEscalator",dependency2.getJavaSourceFrom().getName());
assertEquals("Snapshot",dependency2.getJavaSourceTo().getName());
}