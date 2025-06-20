@Test public void testPath() throws Exception {
assertThat(provider.getPath(),equalTo("/path"));
assertThat(provider.getContextpath(),equalTo("/path"));
assertThat(parameters,not(hasKey("path")));
}