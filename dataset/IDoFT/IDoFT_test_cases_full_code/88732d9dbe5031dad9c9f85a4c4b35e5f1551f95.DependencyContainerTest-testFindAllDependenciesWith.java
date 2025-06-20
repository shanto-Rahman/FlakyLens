@Test public void testFindAllDependenciesWith(){
  TestDataProvider.createSampleDependencies();
  JavaSource producer=JavaSourceContainer.getInstance().getJavaSourceByName("Producer");
  JavaSource product1=JavaSourceContainer.getInstance().getJavaSourceByName("Product1");
  Set<Dependency> foundedDependencies=DependencyContainer.getInstance().findAllDependenciesWith(producer,DependencyType.PRODUCES);
  assertEquals(4,foundedDependencies.size());
  foundedDependencies=DependencyContainer.getInstance().findAllDependenciesWith(producer,DependencyType.EVENT);
  assertEquals(0,foundedDependencies.size());
  foundedDependencies=DependencyContainer.getInstance().findAllDependenciesWith(product1,DependencyType.INSTANCE);
  assertEquals(1,foundedDependencies.size());
}
