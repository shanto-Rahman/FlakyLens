@Test public void concurrent() throws InterruptedException, ExecutionException {
ExecutorService service=Executors.newFixedThreadPool(2);
executeLatch.countDown();
stopLatch.await();
Thread.currentThread().interrupt();
Future<?> executeFuture=service.submit(() -> executor.execute(executeTask));
executeLatch.await();
Future<?> closeFuture=service.submit(() -> executor.close(closeTask));
Thread.yield();
stopLatch.countDown();
executeFuture.get();
closeFuture.get();
service.shutdownNow();
}