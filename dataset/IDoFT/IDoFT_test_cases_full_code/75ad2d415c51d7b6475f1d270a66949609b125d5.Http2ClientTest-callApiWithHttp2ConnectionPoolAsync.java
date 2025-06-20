@Test public void callApiWithHttp2ConnectionPoolAsync() throws Exception {
  Http2ClientConnectionPool.getInstance().clear();
  int asyncRequestNumber=100;
  final Http2Client client=createClient();
  AtomicInteger countComplete=new AtomicInteger(0);
  ClientRequest request=new ClientRequest().setPath(SLOW_MESSAGE).setMethod(Methods.GET);
  request.getRequestHeaders().put(Headers.HOST,"localhost");
  CountDownLatch latch=new CountDownLatch(asyncRequestNumber);
  for (int i=0; i < asyncRequestNumber; i++) {
    client.callService(new URI("https://localhost:7778"),request,Optional.empty()).thenAcceptAsync(clientResponse -> {
      Assert.assertEquals(clientResponse.getAttachment(Http2Client.RESPONSE_BODY),"Hello World!");
      countComplete.getAndIncrement();
      latch.countDown();
    }
);
    Thread.sleep(5);
  }
  latch.await(5,TimeUnit.SECONDS);
  Assert.assertTrue(Http2ClientConnectionPool.getInstance().numberOfConnections() == 1);
  System.out.println("Number of connections: " + Http2ClientConnectionPool.getInstance().numberOfConnections());
  System.out.println("Completed: " + countComplete.get());
}
