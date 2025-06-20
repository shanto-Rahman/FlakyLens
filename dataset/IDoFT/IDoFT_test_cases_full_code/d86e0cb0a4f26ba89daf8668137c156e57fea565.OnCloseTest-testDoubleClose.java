@Test public void testDoubleClose() throws DeploymentException {
  Server server=startServer(DoubleCloseEndpoint.class,ServiceEndpoint.class);
  final CountDownLatch messageLatch=new CountDownLatch(1);
  ClientManager client=createClient();
  try {
    final ClientEndpointConfig cec=ClientEndpointConfig.Builder.create().build();
    client.connectToServer(new Endpoint(){
      @Override public void onOpen(      Session session,      EndpointConfig config){
        try {
          session.getBasicRemote().sendText("message");
        }
 catch (        IOException e) {
        }
      }
      @Override public void onClose(      Session session,      CloseReason closeReason){
        messageLatch.countDown();
      }
    }
,cec,getURI(DoubleCloseEndpoint.class));
    messageLatch.await(2,TimeUnit.SECONDS);
    assertEquals(0,messageLatch.getCount());
    testViaServiceEndpoint(client,ServiceEndpoint.class,POSITIVE,"DoubleCloseEndpoint");
  }
 catch (  Exception e) {
    e.printStackTrace();
    throw new RuntimeException(e.getMessage(),e);
  }
 finally {
    stopServer(server);
  }
}
