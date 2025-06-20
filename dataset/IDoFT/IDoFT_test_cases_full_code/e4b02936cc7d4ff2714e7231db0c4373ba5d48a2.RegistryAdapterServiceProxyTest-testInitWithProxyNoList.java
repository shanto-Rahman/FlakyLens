@Test public void testInitWithProxyNoList() throws Throwable {
  setProperty(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME,proxyAddress);
  HostInitRegistryAdapterServiceConfig.startServices(host);
  ConfigurationState configurationState=getDocument(ConfigurationState.class,UriUtils.buildUriPath(ConfigurationFactoryService.SELF_LINK,RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME));
  assertEquals(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME + " should be " + proxyAddress,proxyAddress,configurationState.value);
  configurationState=getDocument(ConfigurationState.class,UriUtils.buildUriPath(ConfigurationFactoryService.SELF_LINK,RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME));
  assertEquals(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME + " should be " + RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE,configurationState.value);
}
