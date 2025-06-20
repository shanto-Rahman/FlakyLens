@Test public void createWithStringSizes() throws Exception {
assertThat(config.getMaxFileSize(),equalTo(1L));
assertThat(config.getMaxRequestSize(),equalTo(2 * 1024L));
assertThat(config.getFileSizeThreshold(),equalTo(3 * 1024 * 1024));
}