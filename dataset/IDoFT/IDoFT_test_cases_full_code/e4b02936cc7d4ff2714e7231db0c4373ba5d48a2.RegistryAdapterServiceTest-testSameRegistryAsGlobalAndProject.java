@Test public void testSameRegistryAsGlobalAndProject() throws Throwable {
  RegistryState registryState=new RegistryState();
  registryState.address="http://0.0.0.0";
  registryState.name="TestRegistry";
  registryState.tenantLinks=new ArrayList<>();
  doPost(registryState,RegistryFactoryService.SELF_LINK);
  registryState.tenantLinks.add("test-project");
  doPost(registryState,RegistryFactoryService.SELF_LINK);
}
