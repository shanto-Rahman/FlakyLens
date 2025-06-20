@Test public void testCloseByInterrupt() throws Exception {
ExecutorService executor=Executors.newCachedThreadPool();
threadStartLatch.countDown();
thread.start();
threadStartLatch.await();
blockingStartLatch.await();
thread.interrupt();
assertThat(interruptException.get(200,MILLISECONDS)).named("interrupted thread exception").isInstanceOf(ClosedByInterruptException.class);
future.get();
fail();
assertThat(expected.getCause()).named("blocking thread exception").isInstanceOf(AsynchronousCloseException.class);
}