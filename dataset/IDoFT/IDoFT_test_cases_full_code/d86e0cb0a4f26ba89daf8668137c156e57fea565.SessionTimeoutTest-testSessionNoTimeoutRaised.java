@Test public void testSessionNoTimeoutRaised() throws DeploymentException {
  Server server=startServer(SessionNoTimeoutEndpoint.class,ServiceEndpoint.class);
  try {
    final ClientEndpointConfig cec=ClientEndpointConfig.Builder.create().build();
    final CountDownLatch latch=new CountDownLatch(1);
    ClientManager client=createClient();
    client.connectToServer(new Endpoint(){
      @Override public void onOpen(      Session session,      EndpointConfig config){
        session.addMessageHandler(new MessageHandler.Whole<String>(){
          @Override public void onMessage(          String message){
            System.out.println("Client message received");
            assertEquals(POSITIVE,message);
            latch.countDown();
          }
        }
);
        try {
          session.getBasicRemote().sendText("Nothing");
          Thread.sleep(250);
          session.getBasicRemote().sendText("Nothing");
          Thread.sleep(250);
          session.getBasicRemote().sendText("Nothing");
        }
 catch (        Exception e) {
          e.printStackTrace();
        }
      }
    }
,cec,getURI(SessionNoTimeoutEndpoint.class));
    assertTrue(latch.await(2,TimeUnit.SECONDS));
  }
 catch (  Exception e) {
    e.printStackTrace();
    throw new RuntimeException(e.getMessage(),e);
  }
 finally {
    stopServer(server);
  }
}
