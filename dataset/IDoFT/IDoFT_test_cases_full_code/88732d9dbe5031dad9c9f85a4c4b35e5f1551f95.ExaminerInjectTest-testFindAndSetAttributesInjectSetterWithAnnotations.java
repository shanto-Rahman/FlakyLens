@Test public void testFindAndSetAttributesInjectSetterWithAnnotations(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("ZeiterfassungEingabeModel");
  sourceCode="public class ZeiterfassungEingabeModel implements Serializable\n" + "{\n" + "@Inject\n"+ "protected void setBuchungsMonat(@Current @Zeiterfassung Date buchungsMonat)\n"+ "{\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.INJECT,dependency.getDependencyType());
  assertEquals("ZeiterfassungEingabeModel",dependency.getJavaSourceFrom().getName());
  assertEquals("Date",dependency.getJavaSourceTo().getName());
}
