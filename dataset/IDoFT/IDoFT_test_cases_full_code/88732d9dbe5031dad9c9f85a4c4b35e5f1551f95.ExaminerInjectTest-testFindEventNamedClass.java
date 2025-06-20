@Test public void testFindEventNamedClass(){
  DependencyContainer.getInstance().clear();
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("Events");
  sourceCode="     @Stateless\n" + "public class Events {\n" + " @Inject\n"+ " private EventValidator validator;\n"+ " @Inject\n"+ " private PrintingService ps;\n"+ "    }\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.INJECT,dependency.getDependencyType());
  assertEquals("Events",dependency.getJavaSourceFrom().getName());
  assertEquals("EventValidator",dependency.getJavaSourceTo().getName());
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(1);
  assertEquals(DependencyType.INJECT,dependency.getDependencyType());
  assertEquals("Events",dependency.getJavaSourceFrom().getName());
  assertEquals("PrintingService",dependency.getJavaSourceTo().getName());
}
