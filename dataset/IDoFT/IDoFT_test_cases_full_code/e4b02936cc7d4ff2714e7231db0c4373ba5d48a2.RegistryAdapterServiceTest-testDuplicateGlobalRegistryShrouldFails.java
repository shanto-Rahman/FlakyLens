@Test public void testDuplicateGlobalRegistryShrouldFails() throws Throwable {
  RegistryState registryState=new RegistryState();
  registryState.address="http://0.0.0.0";
  registryState.name="TestRegistry";
  doPost(registryState,RegistryFactoryService.SELF_LINK);
  try {
    doPost(registryState,RegistryFactoryService.SELF_LINK);
    fail("Should not be possible to add the same registry twice in the same scope");
  }
 catch (  Exception e) {
    assertTrue(e.getMessage().contains(RegistryFactoryService.REGISTRY_ALREADY_EXISTS));
  }
}
