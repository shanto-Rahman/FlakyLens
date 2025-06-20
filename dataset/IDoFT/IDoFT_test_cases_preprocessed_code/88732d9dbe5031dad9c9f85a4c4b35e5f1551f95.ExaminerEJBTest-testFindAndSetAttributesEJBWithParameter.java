@Test public void testFindAndSetAttributesEJBWithParameter(){
assertEquals(2,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.EJB,dependency.getDependencyType());
assertEquals("AlbumServiceImpl",dependency.getJavaSourceFrom().getName());
assertEquals("UserRepository",dependency.getJavaSourceTo().getName());
assertEquals(DependencyType.EJB,dependency.getDependencyType());
assertEquals("AlbumServiceImpl",dependency.getJavaSourceFrom().getName());
assertEquals("AlbumRepository",dependency.getJavaSourceTo().getName());
}