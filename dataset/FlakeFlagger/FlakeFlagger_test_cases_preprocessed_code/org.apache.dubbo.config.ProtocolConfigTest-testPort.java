@Test public void testPort() throws Exception {
assertThat(protocol.getPort(),equalTo(8080));
assertThat(parameters.isEmpty(),is(true));
}