@Test public void testAddDsAndTestConnection() throws Exception {
Assert.assertNotNull("Reparsing failed:",newList);
Assert.assertNotNull(findNodeWithProperty(newList,"jndi-name","java:jboss/datasources/MyNewDs"));
}