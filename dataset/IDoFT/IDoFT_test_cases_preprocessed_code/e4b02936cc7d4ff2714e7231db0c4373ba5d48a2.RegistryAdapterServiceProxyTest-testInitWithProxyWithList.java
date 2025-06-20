@Test public void testInitWithProxyWithList() throws Throwable {
assertEquals(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME + " should be " + proxyAddress,proxyAddress,configurationState.value);
assertEquals(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME + " should be " + noProxyList,noProxyList,configurationState.value);
}