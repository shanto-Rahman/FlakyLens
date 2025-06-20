@Test public void testReconnectAfterBufferFull() throws Exception {
  final CountDownLatch bufferFull=new CountDownLatch(1);
  int port=MockFluentd.randomPort();
  final List<Event> elist=new ArrayList<Event>();
  final MockFluentd fluentd=new MockFluentd(port,new MockFluentd.MockProcess(){
    public void process(    MessagePack msgpack,    Socket socket) throws IOException {
      try {
        BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
        Unpacker unpacker=msgpack.createUnpacker(in);
        while (true) {
          Event e=unpacker.read(Event.class);
          elist.add(e);
        }
      }
 catch (      EOFException e) {
      }
 finally {
        socket.close();
      }
    }
  }
);
  ExecutorService executor=Executors.newSingleThreadExecutor();
  executor.execute(new Runnable(){
    @Override public void run(){
      try {
        bufferFull.await(20,TimeUnit.SECONDS);
        fluentd.start();
      }
 catch (      InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
);
  Sender sender=new RawSocketSender("localhost",port);
  String tag="tag";
  int i;
  for (i=0; i < 1000000; i++) {
    Map<String,Object> record=new HashMap<String,Object>();
    record.put("num",i);
    record.put("str","name" + i);
    if (bufferFull.getCount() > 0) {
      if (!sender.emit(tag,record)) {
        bufferFull.countDown();
        Thread.sleep(2000);
      }
    }
 else {
      sender.emit(tag,record);
      break;
    }
  }
  sender.close();
  Thread.sleep(2000);
  fluentd.close();
  assertEquals(0,bufferFull.getCount());
  assertEquals(i,elist.size());
}
