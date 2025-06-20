@Test public void testNormal01() throws Exception {
  int port=MockFluentd.randomPort();
  String host="localhost";
  final List<Event> elist=new ArrayList<Event>();
  MockFluentd fluentd=new MockFluentd(port,new MockFluentd.MockProcess(){
    public void process(    MessagePack msgpack,    Socket socket) throws IOException {
      BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
      try {
        Unpacker unpacker=msgpack.createUnpacker(in);
        while (true) {
          Event e=unpacker.read(Event.class);
          elist.add(e);
        }
      }
 catch (      EOFException e) {
      }
    }
  }
);
  FixedThreadManager threadManager=new FixedThreadManager(1);
  threadManager.submit(fluentd);
  fluentd.waitUntilReady();
  FluentLogger logger=FluentLogger.getLogger("testtag",host,port);
{
    Map<String,Object> data=new HashMap<String,Object>();
    data.put("k1","v1");
    data.put("k2","v2");
    logger.log("test01",data);
  }
{
    Map<String,Object> data=new HashMap<String,Object>();
    data.put("k3","v3");
    data.put("k4","v4");
    logger.log("test01",data);
  }
  logger.close();
  Thread.sleep(2000);
  fluentd.close();
  threadManager.join();
  assertEquals(2,elist.size());
  assertEquals("testtag.test01",elist.get(0).tag);
  assertEquals("testtag.test01",elist.get(1).tag);
}
