@Test public void testHost() throws Exception {
assertThat(protocol.getHost(),equalTo("host"));
assertThat(parameters.isEmpty(),is(true));
}