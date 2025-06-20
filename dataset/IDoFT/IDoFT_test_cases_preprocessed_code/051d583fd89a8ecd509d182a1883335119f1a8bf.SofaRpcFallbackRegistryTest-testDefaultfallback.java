@Test public void testDefaultfallback(){
assertNotNull(providerFallback);
assertTrue(providerFallback instanceof DefaultSofaRpcFallback);
assertNotNull(consumerFallback);
assertTrue(consumerFallback instanceof DefaultSofaRpcFallback);
}