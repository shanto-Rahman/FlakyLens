@Test public void sslAnnotationBasedClientConfigurationIsCorrect(){
assertThat(this.applicationContext).isNotNull();
assertThat(this.applicationContext.containsBean("gemfireCache"));
assertThat(this.applicationContext.containsBean("gemfireProperties"));
assertThat(clientCache).isNotNull();
}