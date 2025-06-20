@Test public void testObservesNotify(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.OBSERVES,dependency.getDependencyType());
assertEquals("SnapshotEscalator",dependency.getJavaSourceFrom().getName());
assertEquals("Snapshot",dependency.getJavaSourceTo().getName());
}