@Test public void testSessionTimeoutChanged() throws DeploymentException {
  Server server=startServer(SessionTimeoutChangedEndpoint.class,ServiceEndpoint.class);
  try {
    final ClientEndpointConfig cec=ClientEndpointConfig.Builder.create().build();
    ClientManager client=createClient();
    client.connectToServer(new TestEndpointAdapter(){
      @Override public void onMessage(      String message){
      }
      @Override public void onOpen(      Session session){
        try {
          session.getBasicRemote().sendText("Nothing");
          Thread.sleep(200);
        }
 catch (        Exception e) {
          e.printStackTrace();
        }
      }
      @Override public EndpointConfig getEndpointConfig(){
        return cec;
      }
    }
,cec,getURI(SessionTimeoutChangedEndpoint.class));
    testViaServiceEndpoint(client,ServiceEndpoint.class,POSITIVE,"SessionTimeoutChangedEndpoint");
  }
 catch (  Exception e) {
    e.printStackTrace();
    throw new RuntimeException(e.getMessage(),e);
  }
 finally {
    stopServer(server);
  }
}
