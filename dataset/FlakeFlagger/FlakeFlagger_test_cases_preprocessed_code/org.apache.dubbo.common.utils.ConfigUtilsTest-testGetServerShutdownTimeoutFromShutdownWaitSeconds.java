@Test public void testGetServerShutdownTimeoutFromShutdownWaitSeconds() throws Exception {
assertThat(ConfigUtils.getServerShutdownTimeout(),equalTo(1234 * 1000));
}