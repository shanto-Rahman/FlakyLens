/** 
 * Test of generateDescription method, of class Description.
 */
@Test public void testGenerateDescription(){
  JavaSource javaSource1=JavaSourceFactory.getInstance().newJavaSource("TestJavaSource1");
  JavaSource javaSource2=JavaSourceFactory.getInstance().newJavaSource("TestJavaSource2");
  JavaSource javaSource3=JavaSourceFactory.getInstance().newJavaSource("TestJavaSource3");
  String testPackage="//my/test/package/path";
  javaSource1.setPackagePath(testPackage);
  Dependency dependency12=new Dependency(DependencyType.INJECT,javaSource1,javaSource2);
  Dependency dependency13=new Dependency(DependencyType.OBSERVES,javaSource1,javaSource3);
  List<Dependency> dependencies=new ArrayList<>();
  dependencies.add(dependency12);
  dependencies.add(dependency13);
  DependencyContainer.getInstance().addAll(dependencies);
  String actual=Description.generateDescription(javaSource1);
  assertTrue(actual.indexOf(testPackage) > 0);
  assertTrue(actual.indexOf(javaSource2.getName()) > 0);
  assertTrue(actual.indexOf(javaSource3.getName()) > 0);
}
