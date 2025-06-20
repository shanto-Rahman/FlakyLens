@Test public void testFindAndSetAttributesSetInstance(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.EVENT,dependency.getDependencyType());
assertEquals("TunguskaGate",dependency.getJavaSourceFrom().getName());
assertEquals("BrowserWindow",dependency.getJavaSourceTo().getName());
}