/** 
 * Tests that all possible remote view bindings of a Stateful bean are available, when deployed through a .ear
 * @throws Exception
 */
@Test public void testRemoteBindingsOnSFSB() throws Exception {
Assert.assertNotNull("Null object returned for remote business interface lookup in java:global namespace",remoteBusinessInterface);
Assert.assertNotNull("Null object returned for remote business interface lookup in java:app namespace",remoteBusinessInterfaceInAppNamespace);
Assert.assertNotNull("Null object returned for remote business interface lookup in java:module namespace",remoteBusinessInterfaceInModuleNamespace);
}