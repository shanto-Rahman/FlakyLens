@Test public void testCloseByInterrupt() throws Exception {
  RegularFile file=regularFile(10);
  final FileChannel channel=channel(file,READ,WRITE);
  file.writeLock().lock();
  ExecutorService executor=Executors.newCachedThreadPool();
  final CountDownLatch threadStartLatch=new CountDownLatch(1);
  final SettableFuture<Throwable> interruptException=SettableFuture.create();
  Thread thread=new Thread(new Runnable(){
    @Override public void run(){
      threadStartLatch.countDown();
      try {
        channel.write(ByteBuffer.allocate(20));
        interruptException.set(null);
      }
 catch (      Throwable e) {
        interruptException.set(e);
      }
    }
  }
);
  thread.start();
  threadStartLatch.await();
  Uninterruptibles.sleepUninterruptibly(10,MILLISECONDS);
  CountDownLatch blockingStartLatch=new CountDownLatch(BLOCKING_OP_COUNT);
  List<Future<?>> futures=queueAllBlockingOperations(channel,executor,blockingStartLatch);
  blockingStartLatch.await();
  Uninterruptibles.sleepUninterruptibly(20,MILLISECONDS);
  thread.interrupt();
  assertThat(interruptException.get(200,MILLISECONDS)).named("interrupted thread exception").isInstanceOf(ClosedByInterruptException.class);
  for (  Future<?> future : futures) {
    try {
      future.get();
      fail();
    }
 catch (    ExecutionException expected) {
      assertThat(expected.getCause()).named("blocking thread exception").isInstanceOf(AsynchronousCloseException.class);
    }
  }
}
