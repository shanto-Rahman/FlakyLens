@Test public void shouldApplyTimeouts() throws Exception {
  assertThat("Configurable http client expected",exampleHttpClient,is(instanceOf(Configurable.class)));
  final RequestConfig config=((Configurable)exampleHttpClient).getConfig();
  assertThat(config.getSocketTimeout(),is(34 * 60 * 60* 1000));
  assertThat(config.getConnectTimeout(),is(12 * 60 * 1000));
}
