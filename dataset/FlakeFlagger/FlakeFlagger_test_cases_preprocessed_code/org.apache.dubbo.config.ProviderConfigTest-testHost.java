@Test public void testHost() throws Exception {
assertThat(provider.getHost(),equalTo("demo-host"));
assertThat(parameters,not(hasKey("host")));
}