@Test public void testWait() throws Exception {
assertThat(registry.getWait(),is(10));
assertThat(System.getProperty(Constants.SHUTDOWN_WAIT_KEY),equalTo("10"));
}