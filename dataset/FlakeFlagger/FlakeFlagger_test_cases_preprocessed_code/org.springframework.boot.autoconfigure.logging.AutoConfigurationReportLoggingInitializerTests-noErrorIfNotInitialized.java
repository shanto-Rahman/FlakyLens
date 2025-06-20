@Test public void noErrorIfNotInitialized() throws Exception {
assertThat(this.infoLog.get(0),containsString("Unable to provide auto-configuration report"));
}