/** 
 * Test  {@link ServiceConfigExportedEvent} arising
 */
@Test public void testOnServiceConfigExportedEvent(){
  ServiceConfig<EchoService> serviceConfig=new ServiceConfig<>();
  serviceConfig.setInterface(EchoService.class);
  serviceConfig.setRef(new EchoServiceImpl());
  serviceConfig.setRegistry(new RegistryConfig("N/A"));
  serviceConfig.export();
  String serviceDefinition=writableMetadataService.getServiceDefinition(EchoService.class.getName());
  ServiceDefinition serviceDefinitionBuild=ServiceDefinitionBuilder.build(serviceConfig.getInterfaceClass());
  assertEquals(serviceDefinition,new Gson().toJson(serviceDefinitionBuild));
}
