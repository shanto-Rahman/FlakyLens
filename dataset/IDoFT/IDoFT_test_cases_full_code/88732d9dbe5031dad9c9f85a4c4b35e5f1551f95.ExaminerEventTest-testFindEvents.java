@Test public void testFindEvents(){
  DependencyContainer.getInstance().clear();
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("Events");
  sourceCode="     @Stateless\n" + "public class Events {\n" + "    @PersistenceContext\n"+ " private EntityManager em;\n"+ " @Inject\n"+ " private EventValidator validator;\n"+ " @Inject\n"+ " private PrintingService ps;\n"+ " @Inject\n"+ " Event<AirEvent> monitoring;\n"+ " public List<AirEvent> getEvents() {\n"+ "     return this.em.createNamedQuery(AirEvent.all).getResultList();\n"+ " }\n"+ "    }\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.EVENT,dependency.getDependencyType());
  assertEquals("Events",dependency.getJavaSourceFrom().getName());
  assertEquals("AirEvent",dependency.getJavaSourceTo().getName());
}
