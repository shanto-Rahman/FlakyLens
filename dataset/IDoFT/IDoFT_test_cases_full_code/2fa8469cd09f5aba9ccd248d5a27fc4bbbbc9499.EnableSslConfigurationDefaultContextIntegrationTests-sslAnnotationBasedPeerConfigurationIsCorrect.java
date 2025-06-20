@Test public void sslAnnotationBasedPeerConfigurationIsCorrect(){
  this.applicationContext=newApplicationContext(new MockPropertySource("TestPropertySource"),SslAnnotationBasedPeerConfiguration.class);
  assertThat(this.applicationContext).isNotNull();
  assertThat(this.applicationContext.containsBean("gemfireCache"));
  assertThat(this.applicationContext.containsBean("gemfireProperties"));
  GemFireCache peerCache=this.applicationContext.getBean("gemfireCache",GemFireCache.class);
  assertThat(peerCache).isNotNull();
  Properties gemfireProperties=peerCache.getDistributedSystem().getProperties();
  assertGemFirePropertiesCorrectlySet(gemfireProperties);
}
