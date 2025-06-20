@Test public void testWait() throws Exception {
  try {
    RegistryConfig registry=new RegistryConfig();
    registry.setWait(10);
    assertThat(registry.getWait(),is(10));
    assertThat(System.getProperty(Constants.SHUTDOWN_WAIT_KEY),equalTo("10"));
  }
  finally {
    System.clearProperty(Constants.SHUTDOWN_TIMEOUT_KEY);
  }
}
