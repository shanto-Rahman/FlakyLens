@Test public void testFlushOnClose() throws Exception {
  int port=MockFluentd.randomPort();
  String host="localhost";
  final List<Event> elist=new ArrayList<Event>();
  final CountDownLatch latch=new CountDownLatch(1);
  MockFluentd fluentd=new MockFluentd(port,new MockFluentd.MockProcess(){
    public void process(    MessagePack msgpack,    Socket socket) throws IOException {
      BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
      try {
        Unpacker unpacker=msgpack.createUnpacker(in);
        while (true) {
          Event e=unpacker.read(Event.class);
          elist.add(e);
          latch.countDown();
        }
      }
 catch (      EOFException e) {
      }
    }
  }
);
  FixedThreadManager threadManager=new FixedThreadManager(1);
  FluentLogger logger=FluentLogger.getLogger("prefix",host,port);
{
    Map<String,Object> data=new HashMap<String,Object>();
    data.put("k","v");
    logger.log("tag",data);
  }
  threadManager.submit(fluentd);
  fluentd.waitUntilReady();
  logger.close();
  latch.await(3,TimeUnit.SECONDS);
  fluentd.close();
  threadManager.join();
  assertEquals(1,elist.size());
  Event ev=elist.get(0);
  assertEquals("prefix.tag",ev.tag);
  assertEquals(1,ev.data.size());
  assertTrue(ev.data.containsKey("k"));
  assertTrue(ev.data.containsValue("v"));
}
