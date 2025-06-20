@Test public void testObservesAnnotated(){
  JavaSource javaSource;
  Dependency dependency1;
  Dependency dependency2;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("SnapshotEscalator");
  sourceCode=TestDataProvider.getTestCompleteSourceCodeExample();
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
  dependency1=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.OBSERVES,dependency1.getDependencyType());
  assertEquals("SnapshotEscalator",dependency1.getJavaSourceFrom().getName());
  assertEquals("BrowserWindow",dependency1.getJavaSourceTo().getName());
  dependency2=DependencyContainer.getInstance().getDependencies(javaSource).get(1);
  assertEquals(DependencyType.OBSERVES,dependency2.getDependencyType());
  assertEquals("SnapshotEscalator",dependency2.getJavaSourceFrom().getName());
  assertEquals("Snapshot",dependency2.getJavaSourceTo().getName());
}
