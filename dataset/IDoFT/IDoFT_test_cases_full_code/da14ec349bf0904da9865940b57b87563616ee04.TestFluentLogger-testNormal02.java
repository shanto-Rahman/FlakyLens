@SuppressWarnings("unchecked") @Test public void testNormal02() throws Exception {
  int loggerCount=3;
  int port=MockFluentd.randomPort();
  String host="localhost";
  final List[] elists=new List[loggerCount];
  elists[0]=new ArrayList<Event>();
  elists[1]=new ArrayList<Event>();
  elists[2]=new ArrayList<Event>();
  MockFluentd fluentd=new MockFluentd(port,new MockFluentd.MockProcess(){
    public void process(    MessagePack msgpack,    Socket socket) throws IOException {
      BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
      try {
        Unpacker unpacker=msgpack.createUnpacker(in);
        while (true) {
          Event e=unpacker.read(Event.class);
          if (e.tag.startsWith("noprefix")) {
            elists[2].add(e);
          }
 else           if (e.tag.startsWith("testtag00")) {
            elists[0].add(e);
          }
 else {
            elists[1].add(e);
          }
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
  FluentLogger[] loggers=new FluentLogger[loggerCount];
  int[] counts=new int[]{50,100,75};
  loggers[0]=FluentLogger.getLogger("testtag00",host,port);
{
    for (int i=0; i < counts[0]; i++) {
      Map<String,Object> data=new HashMap<String,Object>();
      data.put("k1","v1");
      data.put("k2","v2");
      loggers[0].log("test00",data);
    }
  }
  loggers[1]=FluentLogger.getLogger("testtag01",host,port);
{
    for (int i=0; i < counts[1]; i++) {
      Map<String,Object> data=new HashMap<String,Object>();
      data.put("k3","v3");
      data.put("k4","v4");
      loggers[1].log("test01",data);
    }
  }
  loggers[2]=FluentLogger.getLogger(null,host,port);
{
    for (int i=0; i < counts[2]; i++) {
      Map<String,Object> data=new HashMap<String,Object>();
      data.put("k5",5555);
      data.put("k6",6666);
      loggers[2].log("noprefix01",data);
    }
  }
  FluentLogger.closeAll();
  Thread.sleep(2000);
  fluentd.close();
  threadManager.join();
  assertEquals(counts[0],elists[0].size());
  for (  Object obj : elists[0]) {
    Event e=(Event)obj;
    assertEquals("testtag00.test00",e.tag);
  }
  assertEquals(counts[1],elists[1].size());
  for (  Object obj : elists[1]) {
    Event e=(Event)obj;
    assertEquals("testtag01.test01",e.tag);
  }
  assertEquals(counts[2],elists[2].size());
  for (  Object obj : elists[2]) {
    Event e=(Event)obj;
    assertEquals("noprefix01",e.tag);
  }
}
