@Test public void testDefaultfallback(){
  SofaRpcFallback providerFallback=SofaRpcFallbackRegistry.getProviderFallback();
  assertNotNull(providerFallback);
  assertTrue(providerFallback instanceof DefaultSofaRpcFallback);
  SofaRpcFallback consumerFallback=SofaRpcFallbackRegistry.getConsumerFallback();
  assertNotNull(consumerFallback);
  assertTrue(consumerFallback instanceof DefaultSofaRpcFallback);
}
