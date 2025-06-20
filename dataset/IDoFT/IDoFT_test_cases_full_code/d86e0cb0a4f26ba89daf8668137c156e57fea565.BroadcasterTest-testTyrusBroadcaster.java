@Test public void testTyrusBroadcaster() throws DeploymentException {
  final CountDownLatch messageLatch=new CountDownLatch(2);
  Server server=startServer(TyrusBroadcasterTestEndpoint.class);
  try {
    final TEndpointAdapter ea1=new TEndpointAdapter(messageLatch);
    final TEndpointAdapter ea2=new TEndpointAdapter(messageLatch);
    final ClientManager client1=createClient();
    client1.connectToServer(ea1,cec,getURI(TyrusBroadcasterTestEndpoint.class));
    final ClientManager client2=createClient();
    client2.connectToServer(ea2,cec,getURI(TyrusBroadcasterTestEndpoint.class));
synchronized (ea1) {
      if (ea1.peer == null) {
        ea1.wait();
      }
    }
synchronized (ea2) {
      if (ea2.peer == null) {
        ea2.wait();
      }
    }
    ea1.peer.sendText(SENT_MESSAGE);
    assertTrue("Timeout reached. Message latch value: " + messageLatch.getCount(),messageLatch.await(5,TimeUnit.SECONDS));
  }
 catch (  Exception e) {
    e.printStackTrace();
    throw new RuntimeException(e.getMessage(),e);
  }
 finally {
    stopServer(server);
  }
}
