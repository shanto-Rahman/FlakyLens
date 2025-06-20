@Test public void testAliases() throws Exception {
  KernelServices services=createKernelServicesBuilder(createAdditionalInitialization()).setSubsystemXmlResource("subsystem.xml").build();
  ModelNode noAliasModel=services.readWholeModel();
  ModelNode aliasModel=services.readWholeModel(true);
  testSSLAlias(services,noAliasModel,aliasModel);
  testSSOAlias(services,noAliasModel,aliasModel);
  testAccessLogAlias(services,noAliasModel,aliasModel);
}
