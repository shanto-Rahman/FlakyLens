@Test public void testWithProxyNoList() throws Throwable {
  setProperty(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME,proxyAddress);
  setProperty(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE);
  RegistryAdapterService registryAdapterService=(RegistryAdapterService)host.startServiceAndWait(RegistryAdapterService.class,RegistryAdapterService.SELF_LINK);
  assertClients(registryAdapterService,proxyAddress,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE);
}
