@Test public void testGetServerShutdownTimeoutFromShutdownWait() throws Exception {
assertThat(ConfigUtils.getServerShutdownTimeout(),equalTo(1234));
}