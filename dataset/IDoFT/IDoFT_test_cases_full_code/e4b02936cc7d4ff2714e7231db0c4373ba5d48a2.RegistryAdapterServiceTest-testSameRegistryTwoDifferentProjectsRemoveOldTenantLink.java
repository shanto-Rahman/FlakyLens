@Test public void testSameRegistryTwoDifferentProjectsRemoveOldTenantLink() throws Throwable {
  RegistryState registryState=new RegistryState();
  registryState.address="http://0.0.0.0";
  registryState.name="TestRegistry";
  registryState.tenantLinks=new ArrayList<>();
  registryState.tenantLinks.add("test-project1");
  doPost(registryState,RegistryFactoryService.SELF_LINK);
  registryState.tenantLinks.remove("test-project1");
  registryState.tenantLinks.add("test-project2");
  doPost(registryState,RegistryFactoryService.SELF_LINK);
}
