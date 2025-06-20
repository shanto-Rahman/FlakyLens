@Test public void testRunnableResponse() throws ExecutionException, InterruptedException {
CompletableFuture<Boolean> completableFuture=CompletableFuture.supplyAsync(() -> {
  try {
    Thread.sleep(500);
  }
 catch (  InterruptedException e) {
    e.printStackTrace();
  }
  return true;
}
,executor);
Thread.sleep(500);
Boolean result=completableFuture.get();
assertThat(result,is(true));
}