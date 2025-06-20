@Test public void testReadChildrenResources() throws Exception {
Assert.assertFalse(children.isEmpty());
Assert.assertNotNull("Default datasource not found",child.getKey());
Assert.assertTrue("Default datasource have no connection URL",child.getValue().hasDefined("connection-url"));
Assert.assertTrue("Default datasource have no JNDI name",child.getValue().hasDefined("jndi-name"));
Assert.assertTrue("Default datasource have no driver",child.getValue().hasDefined("driver-name"));
}