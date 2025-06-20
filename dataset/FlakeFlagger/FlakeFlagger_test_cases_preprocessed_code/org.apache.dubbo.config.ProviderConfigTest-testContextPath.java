@Test public void testContextPath() throws Exception {
assertThat(provider.getContextpath(),equalTo("/context-path"));
assertThat(parameters,not(hasKey("/context-path")));
}