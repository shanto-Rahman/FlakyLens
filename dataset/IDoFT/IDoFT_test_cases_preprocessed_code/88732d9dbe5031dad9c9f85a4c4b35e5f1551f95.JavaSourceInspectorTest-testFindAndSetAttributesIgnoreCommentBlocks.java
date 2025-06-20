@Test public void testFindAndSetAttributesIgnoreCommentBlocks(){
assertEquals(0,DependencyContainer.getInstance().getDependencies(javaSource).size());
}