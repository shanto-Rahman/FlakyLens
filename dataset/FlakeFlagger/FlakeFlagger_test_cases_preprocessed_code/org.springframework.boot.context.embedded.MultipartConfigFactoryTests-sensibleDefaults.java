@Test public void sensibleDefaults(){
assertThat(config.getLocation(),equalTo(""));
assertThat(config.getMaxFileSize(),equalTo(-1L));
assertThat(config.getMaxRequestSize(),equalTo(-1L));
assertThat(config.getFileSizeThreshold(),equalTo(0));
}