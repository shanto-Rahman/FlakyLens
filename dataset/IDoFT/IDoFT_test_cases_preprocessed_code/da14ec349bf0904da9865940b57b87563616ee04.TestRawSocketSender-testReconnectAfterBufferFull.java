@Test public void testReconnectAfterBufferFull() throws Exception {
ExecutorService executor=Executors.newSingleThreadExecutor();
executor.execute(new Runnable(){
  @Override public void run(){
    try {
      bufferFull.await(20,TimeUnit.SECONDS);
      fluentd.start();
    }
 catch (    InterruptedException e) {
      e.printStackTrace();
    }
  }
}
);
bufferFull.await(20,TimeUnit.SECONDS);
if (bufferFull.getCount() > 0) {
if (!sender.emit(tag,record)) {
bufferFull.countDown();
Thread.sleep(2000);
}
}
Thread.sleep(2000);
assertEquals(0,bufferFull.getCount());
assertEquals(i,elist.size());
}