@Test public void testMonitor() throws Exception {
assertThat(module.getMonitor().getAddress(),equalTo("monitor-addr1"));
assertThat(module.getMonitor().getAddress(),equalTo("monitor-addr2"));
}