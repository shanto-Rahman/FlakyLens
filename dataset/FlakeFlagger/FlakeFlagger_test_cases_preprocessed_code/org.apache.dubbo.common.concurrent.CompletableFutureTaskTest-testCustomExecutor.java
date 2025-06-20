@Test public void testCustomExecutor(){
CompletableFuture<Integer> completableFuture=CompletableFuture.supplyAsync(() -> {
  return 0;
}
);
completableFuture.thenRunAsync(mock(Runnable.class),verify(mockedExecutor));
}