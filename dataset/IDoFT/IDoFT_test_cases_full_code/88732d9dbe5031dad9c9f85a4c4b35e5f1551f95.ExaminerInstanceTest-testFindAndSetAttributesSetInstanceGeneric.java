@Test public void testFindAndSetAttributesSetInstanceGeneric(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("SnapshotProvider");
  sourceCode="public class EscalationNotificationBroker {\n" + "@Inject\n" + "   @SnapshotDataCollector"+ "   Instance<DataCollector<?>> dataCollectors;"+ "}";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.INSTANCE,dependency.getDependencyType());
  assertEquals("SnapshotProvider",dependency.getJavaSourceFrom().getName());
  assertEquals("DataCollector",dependency.getJavaSourceTo().getName());
}
