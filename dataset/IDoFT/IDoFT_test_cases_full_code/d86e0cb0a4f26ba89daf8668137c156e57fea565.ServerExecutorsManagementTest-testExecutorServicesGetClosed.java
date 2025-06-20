@Test public void testExecutorServicesGetClosed(){
  try {
    ClientManager clientManager=createClient();
    for (int i=0; i < 100; i++) {
      Server server=startServer(BroadcastingEndpoint.class);
      try {
        final CountDownLatch messageLatch=new CountDownLatch(1);
        clientManager.connectToServer(new Endpoint(){
          @Override public void onOpen(          Session session,          EndpointConfig config){
            session.addMessageHandler(new MessageHandler.Whole<String>(){
              @Override public void onMessage(              String message){
                messageLatch.countDown();
              }
            }
);
          }
        }
,getURI(BroadcastingEndpoint.class));
        assertTrue(messageLatch.await(5,TimeUnit.SECONDS));
      }
  finally {
        stopServer(server);
      }
    }
    int activeThreadsCount=Thread.activeCount();
    assertTrue("Number of active threads is " + activeThreadsCount,activeThreadsCount < 50);
  }
 catch (  Exception e) {
    e.printStackTrace();
    fail();
  }
}
