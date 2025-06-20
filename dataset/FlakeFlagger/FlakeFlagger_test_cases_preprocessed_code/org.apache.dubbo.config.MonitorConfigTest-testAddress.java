@Test public void testAddress() throws Exception {
assertThat(monitor.getAddress(),equalTo("monitor-addr"));
assertThat(parameters.isEmpty(),is(true));
}