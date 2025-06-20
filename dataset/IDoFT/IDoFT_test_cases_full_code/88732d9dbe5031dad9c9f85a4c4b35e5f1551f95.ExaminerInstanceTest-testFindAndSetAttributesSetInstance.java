@Test public void testFindAndSetAttributesSetInstance(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("EscalationNotificationBroker");
  sourceCode="@Singleton\n" + "@ConcurrencyManagement(ConcurrencyManagementType.BEAN)\n" + "public class EscalationNotificationBroker {\n"+ "private static final Logger LOG = Logger.getLogger(EscalationNotificationBroker.class.getName());\n"+ "@Inject NotifierStore notifierStore;\n"+ "@Inject @Any Instance<Transmitter> transmitters;\n"+ "@Inject AsyncTransmitterService asyncService;\n"+ "}";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.INSTANCE,dependency.getDependencyType());
  assertEquals("EscalationNotificationBroker",dependency.getJavaSourceFrom().getName());
  assertEquals("Transmitter",dependency.getJavaSourceTo().getName());
}
