@Test public void testReconnect(TestContext ctx) throws Exception {
  connectionRetryDelay=100;
  connectionRetries=2;
  startProxy(2);
  connect();
  client.stop(ctx.asyncAssertSuccess());
}
