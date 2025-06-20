@Test public void testGetServerShutdownTimeoutFromDefault() throws Exception {
assertThat(ConfigUtils.getServerShutdownTimeout(),equalTo(Constants.DEFAULT_SERVER_SHUTDOWN_TIMEOUT));
}