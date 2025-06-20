@Test public void testObservesWithPhases(){
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("SnapshotEscalator");
  sourceCode=TestDataProvider.getTestSourceCodeBeforeBody() + "public void onToDoChange(@Observes(during = TransactionPhase.AFTER_SUCCESS) @ChangeEvent(ChangeEvent.Type.CREATION) ToDo todo) throws EncodeException {\n" + "List<Script> scripts = this.scripting.activeScripts();\n"+ "try {\n"+ "Bindings binding = this.scriptEngine.createBindings();\n"+ "} catch (Exception e) {\n"+ "throw new IllegalStateException(\"Exception during script evaluation: \" + e, e);\n"+ "}\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.OBSERVES,dependency.getDependencyType());
  assertEquals("SnapshotEscalator",dependency.getJavaSourceFrom().getName());
  assertEquals("ToDo",dependency.getJavaSourceTo().getName());
}
