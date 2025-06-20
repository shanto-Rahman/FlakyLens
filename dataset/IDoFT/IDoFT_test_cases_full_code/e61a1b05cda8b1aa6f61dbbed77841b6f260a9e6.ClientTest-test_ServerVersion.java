@Test public void test_ServerVersion() throws Exception {
  String version=client.getVersion();
  assertThat(version,is(notNullValue()));
}
