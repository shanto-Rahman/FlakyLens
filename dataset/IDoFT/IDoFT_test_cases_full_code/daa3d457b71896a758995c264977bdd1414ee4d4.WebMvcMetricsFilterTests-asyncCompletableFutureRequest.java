@Test public void asyncCompletableFutureRequest() throws Exception {
  AtomicReference<MvcResult> result=new AtomicReference<>();
  Thread backgroundRequest=new Thread(() -> {
    try {
      result.set(this.mvc.perform(get("/api/c1/completableFuture/{id}",1)).andExpect(request().asyncStarted()).andReturn());
    }
 catch (    Exception ex) {
      fail("Failed to execute async request",ex);
    }
  }
);
  backgroundRequest.start();
  this.completableFutureBarrier.await();
  MockClock.clock(this.registry).add(Duration.ofSeconds(2));
  this.completableFutureBarrier.await();
  backgroundRequest.join();
  this.mvc.perform(asyncDispatch(result.get())).andExpect(status().isOk());
  assertThat(this.registry.get("http.server.requests").tags("uri","/api/c1/completableFuture/{id}").timer().totalTime(TimeUnit.SECONDS)).isEqualTo(2);
}
