/** 
 * Test config properties
 * @throws Throwable  Thrown if case of an error
 */
@Test public void testConfigProperties() throws Throwable {
assertNotNull(connectionFactory);
assertNotNull(adminObject);
assertNotNull(connection);
assertEquals("A",connection.getResourceAdapterProperty());
assertEquals("B",connection.getManagedConnectionFactoryProperty());
assertEquals("C",adminObject.getProperty());
}