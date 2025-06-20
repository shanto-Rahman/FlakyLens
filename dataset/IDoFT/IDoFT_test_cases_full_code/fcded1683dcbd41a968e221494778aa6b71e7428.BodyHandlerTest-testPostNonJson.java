@Test public void testPostNonJson() throws Exception {
  final AtomicReference<ClientResponse> reference=new AtomicReference<>();
  final Http2Client client=Http2Client.getInstance();
  final CountDownLatch latch=new CountDownLatch(1);
  final ClientConnection connection;
  try {
    connection=client.connect(new URI("http://localhost:8080"),Http2Client.WORKER,Http2Client.BUFFER_POOL,OptionMap.EMPTY).get();
  }
 catch (  Exception e) {
    throw new ClientException(e);
  }
  try {
    String post="post";
    connection.getIoThread().execute(new Runnable(){
      @Override public void run(){
        final ClientRequest request=new ClientRequest().setMethod(Methods.POST).setPath("/post");
        request.getRequestHeaders().put(Headers.HOST,"localhost");
        request.getRequestHeaders().put(Headers.CONTENT_TYPE,"application/json");
        request.getRequestHeaders().put(Headers.TRANSFER_ENCODING,"chunked");
        connection.sendRequest(request,client.createClientCallback(reference,latch,post));
      }
    }
);
    latch.await(10,TimeUnit.SECONDS);
  }
 catch (  Exception e) {
    logger.error("IOException: ",e);
    throw new ClientException(e);
  }
 finally {
    IoUtils.safeClose(connection);
  }
  int statusCode=reference.get().getResponseCode();
  Assert.assertEquals(400,statusCode);
  if (statusCode == 400) {
    Status status=Config.getInstance().getMapper().readValue(reference.get().getAttachment(Http2Client.RESPONSE_BODY),Status.class);
    Assert.assertNotNull(status);
    Assert.assertEquals("ERR10015",status.getCode());
  }
}
