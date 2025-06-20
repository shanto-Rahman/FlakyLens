@org.junit.Test public void testCloseFrame() throws Exception {
  final int code=1000;
  final String reasonText="TEST";
  final AtomicReference<CloseReason> reason=new AtomicReference<>();
  ByteBuffer payload=ByteBuffer.allocate(reasonText.length() + 2);
  payload.putShort((short)code);
  payload.put(reasonText.getBytes("UTF-8"));
  payload.flip();
  final AtomicBoolean connected=new AtomicBoolean(false);
  final FutureResult latch=new FutureResult();
  final CountDownLatch clientLatch=new CountDownLatch(1);
  final AtomicInteger closeCount=new AtomicInteger();
class TestEndPoint extends Endpoint {
    @Override public void onOpen(    final Session session,    EndpointConfig config){
      connected.set(true);
    }
    @Override public void onClose(    Session session,    CloseReason closeReason){
      closeCount.incrementAndGet();
      reason.set(closeReason);
      clientLatch.countDown();
    }
  }
  ServerWebSocketContainer builder=new ServerWebSocketContainer(TestClassIntrospector.INSTANCE,DefaultServer.getWorker(),DefaultServer.getBufferPool(),Collections.EMPTY_LIST,false,false);
  builder.addEndpoint(ServerEndpointConfig.Builder.create(TestEndPoint.class,"/").configurator(new InstanceConfigurator(new TestEndPoint())).build());
  deployServlet(builder);
  WebSocketTestClient client=new WebSocketTestClient(getVersion(),new URI("ws://" + DefaultServer.getHostAddress("default") + ":"+ DefaultServer.getHostPort("default")+ "/"));
  client.connect();
  client.send(new CloseWebSocketFrame(code,reasonText),new FrameChecker(CloseWebSocketFrame.class,payload.array(),latch));
  latch.getIoFuture().get();
  clientLatch.await();
  Assert.assertEquals(code,reason.get().getCloseCode().getCode());
  Assert.assertEquals(reasonText,reason.get().getReasonPhrase());
  Assert.assertEquals(1,closeCount.get());
  client.destroy();
}
