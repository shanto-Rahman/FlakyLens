@Test public void testPort() throws Exception {
assertThat(provider.getPort(),is(8080));
assertThat(parameters,not(hasKey("port")));
}