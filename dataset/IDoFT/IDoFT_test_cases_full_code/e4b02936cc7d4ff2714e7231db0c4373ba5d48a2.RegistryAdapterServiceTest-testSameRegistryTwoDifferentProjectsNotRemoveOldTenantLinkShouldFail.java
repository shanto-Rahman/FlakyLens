@Test public void testSameRegistryTwoDifferentProjectsNotRemoveOldTenantLinkShouldFail() throws Throwable {
  RegistryState registryState=new RegistryState();
  registryState.address="http://0.0.0.0";
  registryState.name="TestRegistry";
  registryState.tenantLinks=new ArrayList<>();
  registryState.tenantLinks.add("test-project1");
  doPost(registryState,RegistryFactoryService.SELF_LINK);
  registryState.tenantLinks.add("test-project2");
  try {
    doPost(registryState,RegistryFactoryService.SELF_LINK);
    fail("Should not be possible to add the same registry in two different projects");
  }
 catch (  Exception e) {
    assertTrue(e.getMessage().contains(RegistryFactoryService.REGISTRY_ALREADY_EXISTS));
  }
}
