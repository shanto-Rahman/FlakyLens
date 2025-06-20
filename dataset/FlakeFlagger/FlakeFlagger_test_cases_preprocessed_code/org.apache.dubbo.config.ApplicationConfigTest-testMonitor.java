@Test public void testMonitor() throws Exception {
assertThat(application.getMonitor().getAddress(),equalTo("monitor-addr"));
assertThat(application.getMonitor().getAddress(),equalTo("monitor-addr"));
}