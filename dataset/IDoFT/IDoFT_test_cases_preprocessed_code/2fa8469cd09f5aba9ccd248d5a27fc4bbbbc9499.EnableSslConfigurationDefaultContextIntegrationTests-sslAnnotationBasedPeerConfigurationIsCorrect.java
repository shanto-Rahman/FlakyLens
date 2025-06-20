@Test public void sslAnnotationBasedPeerConfigurationIsCorrect(){
assertThat(this.applicationContext).isNotNull();
assertThat(this.applicationContext.containsBean("gemfireCache"));
assertThat(this.applicationContext.containsBean("gemfireProperties"));
assertThat(peerCache).isNotNull();
}