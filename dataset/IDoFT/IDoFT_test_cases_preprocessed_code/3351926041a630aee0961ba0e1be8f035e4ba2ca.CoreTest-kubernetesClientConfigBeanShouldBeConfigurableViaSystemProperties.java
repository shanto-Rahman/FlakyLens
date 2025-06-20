@Test public void kubernetesClientConfigBeanShouldBeConfigurableViaSystemProperties(){
assertThat(config).isNotNull();
assertThat(config.getMasterUrl()).isEqualTo(mockClient.getConfiguration().getMasterUrl());//RW
assertThat(config.getNamespace()).isEqualTo("testns");
assertThat(config.isTrustCerts()).isTrue();
}