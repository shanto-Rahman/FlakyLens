@Test public void testLoadEndpointInterfaceDefinedWebMethods() throws DeploymentUnitProcessingException {
assertTrue(methodNames.contains("performWork"));
assertTrue(methodNames.contains("discoverNewLands"));
assertTrue(methodNames.contains("isWorking"));
assertTrue(methodNames.contains("triggerReport"));
}