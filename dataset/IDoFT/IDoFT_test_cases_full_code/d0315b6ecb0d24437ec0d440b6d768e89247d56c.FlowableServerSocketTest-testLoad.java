@Test public void testLoad() throws InterruptedException {
  reset();
  AtomicBoolean errored=new AtomicBoolean(false);
  for (int k=0; k < 1; k++) {
    System.out.println("loop " + k);
    TestSubscriber<String> ts=TestSubscriber.create();
    final AtomicInteger connections=new AtomicInteger();
    final AtomicInteger port=new AtomicInteger();
    try {
      int bufferSize=4;
      IO.serverSocketAutoAllocatePort(Consumers.set(port)).readTimeoutMs(30000).bufferSize(bufferSize).create().flatMap(new Function<Flowable<byte[]>,Flowable<byte[]>>(){
        @Override public Flowable<byte[]> apply(        Flowable<byte[]> g){
          return g.doOnSubscribe(Consumers.increment(connections)).to(Bytes.collect()).toFlowable().doOnError(Consumers.printStackTrace()).subscribeOn(scheduler).retryWhen(RetryWhen.delay(1,TimeUnit.SECONDS).build());
        }
      }
,1).map(new Function<byte[],String>(){
        @Override public String apply(        byte[] bytes){
          return new String(bytes,UTF_8);
        }
      }
).doOnNext(Consumers.decrement(connections)).doOnError(Consumers.printStackTrace()).doOnError(Consumers.setToTrue(errored)).subscribeOn(scheduler).subscribe(ts);
      TestSubscriber<Object> ts2=TestSubscriber.create();
      final Set<String> messages=new ConcurrentSkipListSet<String>();
      final int messageBlocks=10;
      int numMessages=1000;
      final AtomicInteger openSockets=new AtomicInteger(0);
      Flowable.range(1,numMessages).flatMap(new Function<Integer,Flowable<Object>>(){
        @Override public Flowable<Object> apply(        Integer n){
          return Flowable.defer(new Callable<Flowable<Object>>(){
            @Override public Flowable<Object> call(){
              String id=UUID.randomUUID().toString();
              StringBuilder s=new StringBuilder();
              for (int i=0; i < messageBlocks; i++) {
                s.append(id);
              }
              messages.add(s.toString());
              Socket socket=null;
              try {
                socket=new Socket(LOCALHOST,port.get());
                socket.setReuseAddress(true);
                socket.setSoTimeout(5000);
                openSockets.incrementAndGet();
                OutputStream out=socket.getOutputStream();
                for (int i=0; i < messageBlocks; i++) {
                  out.write(id.getBytes(UTF_8));
                }
                out.close();
                openSockets.decrementAndGet();
              }
 catch (              Exception e) {
                throw new RuntimeException(e);
              }
 finally {
                try {
                  if (socket != null)                   socket.close();
                }
 catch (                IOException e) {
                  e.printStackTrace();
                }
              }
              return Flowable.<Object>just(1);
            }
          }
).timeout(30,TimeUnit.SECONDS).subscribeOn(clientScheduler);
        }
      }
).doOnError(Consumers.printStackTrace()).subscribe(ts2);
      ts2.awaitTerminalEvent();
      ts2.assertComplete();
      Thread.sleep(1000);
      ts.assertValueSet(messages);
      assertFalse(errored.get());
    }
  finally {
      ts.dispose();
      Thread.sleep(1000);
      reset();
    }
  }
}
