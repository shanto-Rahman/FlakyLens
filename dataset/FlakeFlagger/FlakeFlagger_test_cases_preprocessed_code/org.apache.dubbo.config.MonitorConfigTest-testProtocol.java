@Test public void testProtocol() throws Exception {
assertThat(monitor.getProtocol(),equalTo("protocol"));
assertThat(parameters.isEmpty(),is(true));
}