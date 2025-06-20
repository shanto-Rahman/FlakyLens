@Test public void testPostBody() throws Exception {
  final AtomicReference<ClientResponse> reference=new AtomicReference<>();
  final Http2Client client=Http2Client.getInstance();
  final CountDownLatch latch=new CountDownLatch(1);
  final ClientConnection connection;
  try {
    connection=client.connect(new URI("http://localhost:8080"),Http2Client.WORKER,Http2Client.SSL,Http2Client.BUFFER_POOL,OptionMap.EMPTY).get();
  }
 catch (  Exception e) {
    throw new ClientException(e);
  }
  try {
    String post="{\"key\":\"<script>alert('test')</script>\",\"key2\":\"<script>alert('test')</script>\"}";
    connection.getIoThread().execute(new Runnable(){
      @Override public void run(){
        final ClientRequest request=new ClientRequest().setMethod(Methods.POST).setPath("/body");
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
    LOGGER.error("IOException: ",e);
    throw new ClientException(e);
  }
 finally {
    IoUtils.safeClose(connection);
  }
  int statusCode=reference.get().getResponseCode();
  Assert.assertEquals(200,statusCode);
  if (statusCode == 200) {
    String body=reference.get().getAttachment(Http2Client.RESPONSE_BODY);
    Assert.assertNotNull(body);
    Map map=Config.getInstance().getMapper().readValue(body,new TypeReference<HashMap<String,Object>>(){
    }
);
    Assert.assertEquals("<script>alert(\\'test\\')</script>",map.get("key"));
    Assert.assertEquals("<script>alert('test')</script>",map.get("key2"));
  }
}
