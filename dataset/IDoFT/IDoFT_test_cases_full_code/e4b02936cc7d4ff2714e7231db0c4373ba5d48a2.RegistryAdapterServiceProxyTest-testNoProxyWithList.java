@Test public void testNoProxyWithList() throws Throwable {
  setProperty(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE);
  setProperty(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME,noProxyList);
  RegistryAdapterService registryAdapterService=(RegistryAdapterService)host.startServiceAndWait(RegistryAdapterService.class,RegistryAdapterService.SELF_LINK);
  assertClients(registryAdapterService,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE,noProxyList);
}
