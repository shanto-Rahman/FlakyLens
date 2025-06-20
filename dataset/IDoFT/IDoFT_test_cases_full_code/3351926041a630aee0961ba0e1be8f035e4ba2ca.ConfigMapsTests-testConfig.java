@Test public void testConfig(){
  assertThat(mockClient.getConfiguration().getMasterUrl()).isEqualTo(this.config.getMasterUrl());
  assertThat(mockClient.getNamespace()).isEqualTo(this.config.getNamespace());
}
