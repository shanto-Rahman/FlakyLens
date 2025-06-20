@Test public void create() throws Exception {
assertThat(config.getLocation(),equalTo("loc"));
assertThat(config.getMaxFileSize(),equalTo(1L));
assertThat(config.getMaxRequestSize(),equalTo(2L));
assertThat(config.getFileSizeThreshold(),equalTo(3));
}