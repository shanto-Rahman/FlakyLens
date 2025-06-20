@Test public void testSessionTimeout() throws DeploymentException {
  Server server=startServer(SessionTimeoutEndpoint.class,ServiceEndpoint.class);
  try {
    final ClientEndpointConfig cec=ClientEndpointConfig.Builder.create().build();
    final CountDownLatch latch=new CountDownLatch(1);
    ClientManager client=createClient();
    client.connectToServer(new Endpoint(){
      @Override public void onOpen(      Session session,      EndpointConfig config){
      }
      @Override public void onClose(      Session session,      CloseReason closeReason){
        assertEquals(1000,closeReason.getCloseCode().getCode());
        latch.countDown();
      }
    }
,cec,getURI(SessionTimeoutEndpoint.class));
    assertTrue(latch.await(5,TimeUnit.SECONDS));
    testViaServiceEndpoint(client,ServiceEndpoint.class,POSITIVE,"SessionTimeoutEndpoint");
  }
 catch (  Exception e) {
    e.printStackTrace();
    throw new RuntimeException(e.getMessage(),e);
  }
 finally {
    stopServer(server);
  }
}
