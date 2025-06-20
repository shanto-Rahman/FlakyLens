@Test public void testFindAndSetAttributesResourceMappedName(){
  JavaSource javaSource;
  Dependency dependency;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("SimplifiedMessageReceiver");
  sourceCode="package de.x.y;\n" + "public class SimplifiedMessageReceiver {\n" + "@Resource(mappedName=\"java:global/jms/myQueue2\")\n"+ "Queue myQueue;\n"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  assertEquals(DependencyType.RESOURCE,dependency.getDependencyType());
  assertEquals("SimplifiedMessageReceiver",dependency.getJavaSourceFrom().getName());
  assertEquals("Queue",dependency.getJavaSourceTo().getName());
}
