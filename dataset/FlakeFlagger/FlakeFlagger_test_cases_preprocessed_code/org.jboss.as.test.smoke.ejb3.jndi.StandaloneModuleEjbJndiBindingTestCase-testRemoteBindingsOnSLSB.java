/** 
 * Tests that all possible remote view bindings of a Stateless bean are available.
 * @throws Exception
 */
@Test public void testRemoteBindingsOnSLSB() throws Exception {
Assert.assertNotNull("Null object returned for remote business interface lookup in java:global namespace",remoteBusinessInterface);
Assert.assertNotNull("Null object returned for remote business interface lookup in java:app namespace",remoteBusinessInterfaceInAppNamespace);
Assert.assertNotNull("Null object returned for remote business interface lookup in java:module namespace",remoteBusinessInterfaceInModuleNamespace);
}