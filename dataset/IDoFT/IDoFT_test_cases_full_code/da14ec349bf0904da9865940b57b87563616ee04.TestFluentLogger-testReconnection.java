@Test public void testReconnection() throws Exception {
  int port=MockFluentd.randomPort();
  String host="localhost";
  final List<Event> elist1=new ArrayList<Event>();
  final AtomicReference<Exception> lastError=new AtomicReference<Exception>();
  FixedThreadManager threadManager=new FixedThreadManager(2);
  MockFluentd fluentd1=new MockFluentd(port,new MockFluentd.MockProcess(){
    public void process(    MessagePack msgpack,    Socket socket) throws IOException {
      BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
      try {
        Unpacker unpacker=msgpack.createUnpacker(in);
        while (true) {
          Event e=unpacker.read(Event.class);
          elist1.add(e);
          if (elist1.size() >= 1)           break;
        }
        socket.close();
      }
 catch (      EOFException e) {
      }
    }
  }
);
  threadManager.submit(fluentd1);
  fluentd1.waitUntilReady();
  final FluentLogger logger=FluentLogger.getLogger("testtag",host,port);
  final ErrorHandler errorHandler=new ErrorHandler(){
    @Override public void handleNetworkError(    IOException ex){
      lastError.set(ex);
    }
  }
;
  logger.setErrorHandler(errorHandler);
  assertFalse(logger.isConnected());
{
    Map<String,Object> data=new HashMap<String,Object>();
    data.put("k1","v1");
    data.put("k2","v2");
    logger.log("test01",data);
  }
  assertTrue(logger.isConnected());
  TimeUnit.MILLISECONDS.sleep(500);
  _logger.info("Closing the current fluentd instance");
  fluentd1.closeClientSockets();
  fluentd1.close();
  TimeUnit.MILLISECONDS.sleep(500);
  assertTrue(logger.isConnected());
  for (int i=0; i < 2; i++) {
    assertNull(lastError.get());
{
      Map<String,Object> data=new HashMap<String,Object>();
      data.put("k3","v3");
      data.put("k4","v4");
      logger.log("test01",data);
    }
    assertTrue(lastError.get() instanceof IOException);
    lastError.set(null);
    assertFalse(logger.isConnected());
    TimeUnit.MILLISECONDS.sleep((long)(ExponentialDelayReconnector.WAIT_MILLIS * 1.5));
  }
  logger.removeErrorHandler();
{
    Map<String,Object> data=new HashMap<String,Object>();
    data.put("k3","v3");
    data.put("k4","v4");
    logger.log("test01",data);
  }
  assertNull(lastError.get());
  lastError.set(null);
  logger.setErrorHandler(errorHandler);
  final List<Event> elist2=new ArrayList<Event>();
  MockFluentd fluentd2=new MockFluentd(port,new MockFluentd.MockProcess(){
    public void process(    MessagePack msgpack,    Socket socket) throws IOException {
      BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
      try {
        Unpacker unpacker=msgpack.createUnpacker(in);
        while (true) {
          Event e=unpacker.read(Event.class);
          elist2.add(e);
        }
      }
 catch (      EOFException e) {
      }
    }
  }
);
  threadManager.submit(fluentd2);
  fluentd2.waitUntilReady();
  TimeUnit.MILLISECONDS.sleep((long)(ExponentialDelayReconnector.WAIT_MILLIS * 1.5));
{
    Map<String,Object> data=new HashMap<String,Object>();
    data.put("k5","v5");
    data.put("k6","v6");
    logger.log("test01",data);
  }
  assertNull(lastError.get());
  assertTrue(logger.isConnected());
  FluentLogger.closeAll();
  Thread.sleep(2000);
  fluentd2.close();
  TimeUnit.MILLISECONDS.sleep(2000);
  threadManager.join();
  assertNull(lastError.get());
  assertEquals(1,elist1.size());
  assertEquals("testtag.test01",elist1.get(0).tag);
  assertEquals(4,elist2.size());
  for (int i=0; i < elist2.size(); i++) {
    assertEquals("testtag.test01",elist2.get(i).tag);
  }
}
