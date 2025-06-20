@Test public void testReadResourceResources() throws Exception {
Assert.assertFalse(children.isEmpty());
Assert.assertNotNull("Default driver description have no attributes",child.getKey());
Assert.assertTrue("Default driver description have no xa-datasource-class attribute",keys.contains("driver-xa-datasource-class-name"));
Assert.assertTrue("Default driver description have no module-slot attribute",keys.contains("module-slot"));
Assert.assertTrue("Default driver description have no driver-name attribute",keys.contains("driver-name"));
}