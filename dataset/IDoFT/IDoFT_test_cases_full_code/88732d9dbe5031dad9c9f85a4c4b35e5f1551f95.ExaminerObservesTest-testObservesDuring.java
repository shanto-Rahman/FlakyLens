@Test public void testObservesDuring(){
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("SnapshotEscalator");
  sourceCode=TestDataProvider.getTestSourceCodeBeforeBody() + "public void escalate(@Observes(during=BEFORE_COMPLETION) @Severity(Severity.Level.HEARTBEAT) Snapshot current) {\n" + "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.OBSERVES,dependency.getDependencyType());
  assertEquals("SnapshotEscalator",dependency.getJavaSourceFrom().getName());
  assertEquals("Snapshot",dependency.getJavaSourceTo().getName());
}
