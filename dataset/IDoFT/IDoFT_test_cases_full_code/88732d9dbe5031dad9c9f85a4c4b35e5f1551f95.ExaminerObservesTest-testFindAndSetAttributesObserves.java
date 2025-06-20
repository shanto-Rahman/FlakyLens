@Test public void testFindAndSetAttributesObserves(){
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("SnapshotEscalator");
  sourceCode=TestDataProvider.getTestSourceCodeBeforeBody() + "public void escalate(@Observes @Severity(Severity.Level.HEARTBEAT) Snapshot current) {\n" + "List<Script> scripts = this.scripting.activeScripts();\n"+ "try {\n"+ "Bindings binding = this.scriptEngine.createBindings();\n"+ "binding.put(\"current\", current);\n"+ "Snapshot recent = this.recentSnapshots.get(current.getInstanceName());\n"+ "binding.put(\"previous\", recent);\n"+ "long start = System.currentTimeMillis();\n"+ "} catch (Exception e) {\n"+ "throw new IllegalStateException(\"Exception during script evaluation: \" + e, e);\n"+ "}\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.OBSERVES,dependency.getDependencyType());
  assertEquals("SnapshotEscalator",dependency.getJavaSourceFrom().getName());
  assertEquals("Snapshot",dependency.getJavaSourceTo().getName());
}
