/** 
 * Tests that all possible local view bindings of a Stateful bean are available.
 * @throws Exception
 */
@Test public void testLocalBindingsOnSFSB() throws Exception {
Assert.assertNotNull("Null object returned for local business interface lookup in java:global namespace",localBusinessInterface);
Assert.assertNotNull("Null object returned for no-interface view lookup in java:global namespace",noInterfaceView);
Assert.assertNotNull("Null object returned for local business interface lookup in java:app namespace",localBusinessInterfaceInAppNamespace);
Assert.assertNotNull("Null object returned for no-interface view lookup in java:app namespace",noInterfaceViewInAppNamespace);
Assert.assertNotNull("Null object returned for local business interface lookup in java:module namespace",localBusinessInterfaceInModuleNamespace);
Assert.assertNotNull("Null object returned for no-interface view lookup in java:module namespace",noInterfaceViewInModuleNamespace);
}