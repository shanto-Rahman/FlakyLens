@Test public void testExecute__Component_instance_noSpecifiedProps() throws Exception {
assertEquals(1,tree.getChildren().size());
assertEquals("Component:1",componentNode.getName());
assertEquals(componentResource,componentNode.getObject());
assertEquals(1,componentNode.getChildren().size());
assertSame(hostComponentResultNode,componentNode.getChild("host_components"));
assertEquals("false",hostComponentResultNode.getProperty("isCollection"));
}