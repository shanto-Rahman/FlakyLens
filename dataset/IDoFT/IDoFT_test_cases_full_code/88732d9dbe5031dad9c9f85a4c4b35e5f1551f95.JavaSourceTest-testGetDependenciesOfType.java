@Test public void testGetDependenciesOfType(){
  JavaSource javaSource1=new JavaSource("Testclass01");
  JavaSource javaSource2=new JavaSource("Testclass02");
  JavaSource javaSource3=new JavaSource("Testclass03");
  JavaSource javaSource4=new JavaSource("Testclass04");
  Dependency dependency1_2=new Dependency(DependencyType.INJECT,javaSource1,javaSource2);
  Dependency dependency1_3=new Dependency(DependencyType.INJECT,javaSource1,javaSource3);
  Dependency dependency1_4=new Dependency(DependencyType.EVENT,javaSource1,javaSource4);
  DependencyContainer.getInstance().add(dependency1_2);
  DependencyContainer.getInstance().add(dependency1_3);
  DependencyContainer.getInstance().add(dependency1_4);
  assertEquals(2,DependencyContainer.getInstance().getDependenciesOfType(DependencyType.INJECT).size());
  assertEquals(1,DependencyContainer.getInstance().getDependenciesOfType(DependencyType.EVENT).size());
  assertEquals(0,DependencyContainer.getInstance().getDependenciesOfType(DependencyType.EJB).size());
}
