@Test public void testFindAndSetAttributesManyToMany(){
assertEquals(1,DependencyContainer.getInstance().getDependencies(javaSource).size());
assertEquals(DependencyType.MANY_TO_MANY,dependency.getDependencyType());
assertEquals("User",dependency.getJavaSourceFrom().getName());
assertEquals("Group",dependency.getJavaSourceTo().getName());
}