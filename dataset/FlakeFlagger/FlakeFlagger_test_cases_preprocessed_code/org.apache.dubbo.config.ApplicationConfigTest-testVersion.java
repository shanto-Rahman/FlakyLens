@Test public void testVersion() throws Exception {
assertThat(application.getVersion(),equalTo("1.0.0"));
assertThat(parameters,hasEntry("application.version","1.0.0"));
}