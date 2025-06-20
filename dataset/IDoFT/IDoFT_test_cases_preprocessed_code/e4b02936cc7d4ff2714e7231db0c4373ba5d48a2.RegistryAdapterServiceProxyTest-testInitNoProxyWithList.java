@Test public void testInitNoProxyWithList() throws Throwable {
assertEquals(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME + " should be " + RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE,configurationState.value);
assertEquals(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME + " should be " + noProxyList,noProxyList,configurationState.value);
}