@Test @Repeat(50) public void testAcceptEitherAsyncWithExecutor(TestContext tc){
  Async async1=tc.async();
  Async async11=tc.async();
  Async async2=tc.async();
  Async async3=tc.async();
  VertxCompletableFuture<Integer> success=new VertxCompletableFuture<>(vertx);
  success.complete(1);
  VertxCompletableFuture<Integer> success2=new VertxCompletableFuture<>(vertx);
  vertx.setTimer(100,l -> success2.complete(42));
  VertxCompletableFuture<Integer> failure=new VertxCompletableFuture<>(vertx);
  failure.completeExceptionally(new RuntimeException("My bad"));
  vertx.runOnContext(v -> {
    String thread=Thread.currentThread().getName();
    success.acceptEitherAsync(success2,i -> {
      tc.assertNotEquals(thread,Thread.currentThread().getName());
      tc.assertEquals(i,1);
      async1.complete();
    }
,executor);
    success2.acceptEitherAsync(success,i -> {
      tc.assertNotEquals(thread,Thread.currentThread().getName());
      tc.assertEquals(i,1);
      async11.complete();
    }
,executor);
    failure.acceptEitherAsync(success,i -> tc.fail("Should not be called"),executor).whenComplete((res,err) -> {
      tc.assertNotNull(err);
      tc.assertNull(res);
      async2.complete();
    }
);
    success.acceptEitherAsync(failure,i -> {
      tc.assertNotEquals(thread,Thread.currentThread().getName());
      tc.assertEquals(i,1);
      async3.complete();
    }
,executor);
  }
);
}
