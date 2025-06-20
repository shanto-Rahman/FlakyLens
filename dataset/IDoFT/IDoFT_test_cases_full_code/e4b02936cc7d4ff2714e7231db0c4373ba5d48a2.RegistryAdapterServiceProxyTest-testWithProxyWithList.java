@Test public void testWithProxyWithList() throws Throwable {
  setProperty(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME,proxyAddress);
  setProperty(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME,noProxyList);
  RegistryAdapterService registryAdapterService=(RegistryAdapterService)host.startServiceAndWait(RegistryAdapterService.class,RegistryAdapterService.SELF_LINK);
  assertClients(registryAdapterService,proxyAddress,noProxyList);
}
