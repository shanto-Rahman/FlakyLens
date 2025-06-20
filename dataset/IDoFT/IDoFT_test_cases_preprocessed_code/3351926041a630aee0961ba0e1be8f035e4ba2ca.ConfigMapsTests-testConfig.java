@Test public void testConfig(){
assertThat(mockClient.getConfiguration().getMasterUrl()).isEqualTo(this.config.getMasterUrl());//RW
assertThat(mockClient.getNamespace()).isEqualTo(this.config.getNamespace());//RW
}