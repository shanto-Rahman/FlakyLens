@Test public void testObservesWithPhases(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.OBSERVES,dependency.getDependencyType());
assertEquals("SnapshotEscalator",dependency.getJavaSourceFrom().getName());
assertEquals("ToDo",dependency.getJavaSourceTo().getName());
}