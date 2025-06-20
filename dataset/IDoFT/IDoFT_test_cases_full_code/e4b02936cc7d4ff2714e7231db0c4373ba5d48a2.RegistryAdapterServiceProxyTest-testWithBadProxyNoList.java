@Test public void testWithBadProxyNoList() throws Throwable {
  setProperty(RegistryAdapterService.REGISTRY_PROXY_PARAM_NAME,"/foo bar");
  setProperty(RegistryAdapterService.REGISTRY_NO_PROXY_LIST_PARAM_NAME,RegistryAdapterService.REGISTRY_PROXY_NULL_VALUE);
  RegistryAdapterService registryAdapterService=(RegistryAdapterService)host.startServiceAndWait(RegistryAdapterService.class,RegistryAdapterService.SELF_LINK);
  Field field=RegistryAdapterService.class.getDeclaredField("serviceClientProxy");
  field.setAccessible(true);
  NettyHttpServiceClient serviceClientProxy=(NettyHttpServiceClient)field.get(registryAdapterService);
  assertNull("When bad proxy is set the serviceClientProxy should be null.",serviceClientProxy);
}
