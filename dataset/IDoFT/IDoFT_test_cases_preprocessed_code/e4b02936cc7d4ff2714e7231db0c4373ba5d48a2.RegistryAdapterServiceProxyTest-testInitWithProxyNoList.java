@Test public void testInitWithProxyNoList() throws Throwable {
assertEquals(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME + " should be " + proxyAddress,proxyAddress,configurationState.value);
assertEquals(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME + " should be " + RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE,configurationState.value);
}