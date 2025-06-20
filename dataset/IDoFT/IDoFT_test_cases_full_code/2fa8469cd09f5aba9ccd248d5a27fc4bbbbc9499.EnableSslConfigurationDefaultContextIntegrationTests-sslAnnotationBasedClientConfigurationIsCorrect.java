@Test public void sslAnnotationBasedClientConfigurationIsCorrect(){
  this.applicationContext=newApplicationContext(new MockPropertySource("TestPropertySource"),SslAnnotationBasedClientConfiguration.class);
  assertThat(this.applicationContext).isNotNull();
  assertThat(this.applicationContext.containsBean("gemfireCache"));
  assertThat(this.applicationContext.containsBean("gemfireProperties"));
  GemFireCache clientCache=this.applicationContext.getBean("gemfireCache",GemFireCache.class);
  Properties gemfireProperties=clientCache.getDistributedSystem().getProperties();
  assertThat(clientCache).isNotNull();
  assertGemFirePropertiesCorrectlySet(gemfireProperties);
}
