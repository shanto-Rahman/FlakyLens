@Test public void testName() throws Exception {
assertThat(application.getName(),equalTo("app"));
assertThat(application.getName(),equalTo("app2"));
assertThat(parameters,hasEntry(Constants.APPLICATION_KEY,"app2"));
}