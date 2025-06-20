@Test public void testCreate() throws InterruptedException {
CompletableFuture<Boolean> completableFuture=CompletableFuture.supplyAsync(() -> {
  countDownLatch.countDown();
  return true;
}
,executor);
countDownLatch.countDown();
countDownLatch.await();
}