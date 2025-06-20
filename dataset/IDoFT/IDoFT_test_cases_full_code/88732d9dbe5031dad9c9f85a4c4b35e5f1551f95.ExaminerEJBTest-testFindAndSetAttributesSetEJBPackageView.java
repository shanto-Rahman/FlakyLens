@Test public void testFindAndSetAttributesSetEJBPackageView(){
  JavaSource javaSource;
  String sourceCode;
  javaSource=JavaSourceFactory.getInstance().newJavaSource("MyTestClass");
  sourceCode="public abstract class MyTestClass {\n" + "@EJB\n" + "PersonSessionBean bean;"+ "}\n";
  javaSource.setSourceCode(sourceCode);
  examiner.examine(javaSource);
  assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
  Dependency dependency;
  dependency=DependencyContainer.getInstance().getDependencies(javaSource).get(0);
  assertEquals(DependencyType.EJB,dependency.getDependencyType());
  assertEquals("MyTestClass",dependency.getJavaSourceFrom().getName());
  assertEquals("PersonSessionBean",dependency.getJavaSourceTo().getName());
}
