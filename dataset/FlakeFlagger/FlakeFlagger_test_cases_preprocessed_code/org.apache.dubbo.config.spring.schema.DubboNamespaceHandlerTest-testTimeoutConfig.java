@Test public void testTimeoutConfig(){
assertThat(providerConfigMap.get("org.apache.dubbo.config.ProviderConfig").getTimeout(),is(2000));
}