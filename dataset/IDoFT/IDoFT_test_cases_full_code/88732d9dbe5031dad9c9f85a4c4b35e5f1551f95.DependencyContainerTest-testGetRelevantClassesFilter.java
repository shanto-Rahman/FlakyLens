@Test public void testGetRelevantClassesFilter(){
  JavaSourceContainer.getInstance().clear();
  int count=10;
  int count1=0;
  int count2=0;
  DependencyType type1=DependencyType.INJECT;
  DependencyType type2=DependencyType.EJB;
  JavaSource javaSourceType1=JavaSourceFactory.getInstance().newJavaSource("Testinject");
  JavaSourceContainer.getInstance().add(javaSourceType1);
  JavaSource javaSourceType2=JavaSourceFactory.getInstance().newJavaSource("TestEjb");
  JavaSourceContainer.getInstance().add(javaSourceType2);
  for (int i=0; i < count; i++) {
    String name="Testclass " + i;
    JavaSource javaSource=JavaSourceFactory.getInstance().newJavaSource(name);
    List<Dependency> injected=new ArrayList<>();
    if (i % 2 > 0) {
      injected.add(new Dependency(type1,javaSource,javaSourceType1));
      count1++;
    }
 else {
      injected.add(new Dependency(type2,javaSource,javaSourceType2));
      count2++;
    }
    JavaSourceContainer.getInstance().add(javaSource);
    DependencyContainer.getInstance().addAll(injected);
  }
  DependencyFilter filter1=new DependencyFilter().addType(type1);
  assertEquals(count1 + 1,DependencyContainer.getInstance().getFilteredJavaSources(filter1).size());
  DependencyFilter filter2=new DependencyFilter().addType(type2);
  assertEquals(count2 + 1,DependencyContainer.getInstance().getFilteredJavaSources(filter2).size());
}
