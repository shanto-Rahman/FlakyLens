@Test public void testGracefulShutdown() throws Exception {
while (requestConns.getCount() > 0) {
  requestConns.countDown();
}
requestConns.countDown();
if (b == null) {
}
requestConns.countDown();
openServerConns.incrementAndGet();
closedServerConns.incrementAndGet();
openClientConns.incrementAndGet();
closedClientConns.incrementAndGet();
Assert.assertEquals("Test server status",IOReactorStatus.ACTIVE,this.server.getStatus());
if (sessionRequest.getException() != null) {
}
Assert.assertNotNull(sessionRequest.getSession());
Assert.assertEquals("Test client status",IOReactorStatus.ACTIVE,this.client.getStatus());
requestConns.await();
Assert.assertEquals(0,requestConns.getCount());
Assert.assertEquals(openClientConns.get(),closedClientConns.get());
Assert.assertEquals(openServerConns.get(),closedServerConns.get());
}