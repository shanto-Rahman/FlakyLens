@Ignore("Manual testing.") @Test public void testServer() throws IOException, DeploymentException {
  final Server server=startServer(AutobahnApplicationConfig.class);
  try {
    System.in.read();
  }
  finally {
    stopServer(server);
  }
}
