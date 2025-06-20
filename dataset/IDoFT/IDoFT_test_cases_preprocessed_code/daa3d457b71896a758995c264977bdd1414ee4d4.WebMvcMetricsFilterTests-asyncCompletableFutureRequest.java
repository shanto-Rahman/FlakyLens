@Test public void asyncCompletableFutureRequest() throws Exception {
fail("Failed to execute async request",ex);
backgroundRequest.start();
this.completableFutureBarrier.await();
this.completableFutureBarrier.await();
backgroundRequest.join();
assertThat(this.registry.get("http.server.requests").tags("uri","/api/c1/completableFuture/{id}").timer().totalTime(TimeUnit.SECONDS)).isEqualTo(2);
}