@Test public void testExecute__Component_collection_noSpecifiedProps() throws Exception {
assertEquals("true",tree.getProperty("isCollection"));
assertEquals(1,tree.getChildren().size());
assertSame(componentResource,componentNode.getObject());
assertEquals(0,componentNode.getChildren().size());
}