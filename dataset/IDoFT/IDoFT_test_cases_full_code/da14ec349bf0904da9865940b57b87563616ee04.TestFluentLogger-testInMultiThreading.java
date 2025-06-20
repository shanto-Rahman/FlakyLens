@Test public void testInMultiThreading() throws Exception {
  final int N=15;
  final int LOOP=15000;
  final String tag="foodb.bartbl";
  final ArrayList<Long> counters=new ArrayList<Long>(N);
  for (int i=0; i < N; i++)   counters.add(0L);
  final int port=MockFluentd.randomPort();
  final String host="localhost";
  MockFluentd fluentd=new MockFluentd(port,new MockFluentd.MockProcess(){
    public void process(    MessagePack msgpack,    Socket socket) throws IOException {
      BufferedInputStream in=new BufferedInputStream(socket.getInputStream());
      try {
        while (true) {
          Unpacker unpacker=msgpack.createUnpacker(in);
          Event e=unpacker.read(Event.class);
          if (e.tag.equals(tag)) {
            for (            Map.Entry<String,Object> entry : e.data.entrySet()) {
              Integer index=Integer.valueOf(entry.getKey());
              Long i=counters.get(index);
              counters.set(index,i + (Long)entry.getValue());
            }
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
  final FluentLogger logger=FluentLogger.getLogger(null,host,port);
  ExecutorService executorService=Executors.newFixedThreadPool(N);
  for (int i=0; i < N; i++) {
    final int ii=i;
    executorService.execute(new Runnable(){
      @Override public void run(){
        Map<String,Object> event=new HashMap<String,Object>();
        for (int j=0; j <= ii; j++) {
          event.put(String.valueOf(j),j);
        }
        for (int j=0; j < LOOP; j++) {
          logger.log(tag,event);
          if (j % 500 == ii)           logger.flush();
        }
        logger.flush();
      }
    }
);
  }
  Thread.sleep(1000);
  executorService.shutdown();
  executorService.awaitTermination(300,TimeUnit.SECONDS);
  logger.close();
  Thread.sleep(2000);
  fluentd.close();
  threadManager.join();
  for (int i=0; i < N; i++) {
    assertEquals((i * LOOP * (N - i)),(long)counters.get(i));
  }
}
