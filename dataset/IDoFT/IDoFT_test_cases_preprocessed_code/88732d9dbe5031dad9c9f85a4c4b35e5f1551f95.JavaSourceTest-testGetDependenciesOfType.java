@Test public void testGetDependenciesOfType(){
assertEquals(2,DependencyContainer.getInstance().getDependenciesOfType(DependencyType.INJECT).size());
assertEquals(1,DependencyContainer.getInstance().getDependenciesOfType(DependencyType.EVENT).size());
assertEquals(0,DependencyContainer.getInstance().getDependenciesOfType(DependencyType.EJB).size());
}