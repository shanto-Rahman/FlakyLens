@Test public void testExecute__collection_nullInternalPredicate_nonNullUserPredicate() throws Exception {
assertEquals("true",tree.getProperty("isCollection"));
assertEquals(1,tree.getChildren().size());
assertSame(clusterResource,clusterNode.getObject());
assertEquals(0,clusterNode.getChildren().size());
}