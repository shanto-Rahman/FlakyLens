@Test public void testGetWithoutTid() throws Exception {
  final Http2Client client=Http2Client.getInstance();
  final CountDownLatch latch=new CountDownLatch(1);
  final ClientConnection connection;
  try {
    connection=client.connect(new URI("http://localhost:8080"),Http2Client.WORKER,Http2Client.BUFFER_POOL,OptionMap.EMPTY).get();
  }
 catch (  Exception e) {
    throw new ClientException(e);
  }
  final AtomicReference<ClientResponse> reference=new AtomicReference<>();
  try {
    ClientRequest request=new ClientRequest().setPath("/without").setMethod(Methods.GET);
    request.getRequestHeaders().put(Headers.HOST,"localhost");
    connection.sendRequest(request,client.createClientCallback(reference,latch));
    latch.await();
  }
 catch (  Exception e) {
    logger.error("Exception: ",e);
    throw new ClientException(e);
  }
 finally {
    IoUtils.safeClose(connection);
  }
  int statusCode=reference.get().getResponseCode();
  String body=reference.get().getAttachment(Http2Client.RESPONSE_BODY);
  Assert.assertEquals(200,statusCode);
  Assert.assertNotNull(body);
  System.out.println("correlationId = " + body);
}
