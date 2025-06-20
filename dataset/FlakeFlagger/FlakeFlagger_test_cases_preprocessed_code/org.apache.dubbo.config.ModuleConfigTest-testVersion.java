@Test public void testVersion() throws Exception {
assertThat(module.getVersion(),equalTo("1.0.0"));
assertThat(parameters,hasEntry("module.version","1.0.0"));
}