@Test public void asyncCallableRequest() throws Exception {
  AtomicReference<MvcResult> result=new AtomicReference<>();
  Thread backgroundRequest=new Thread(() -> {
    try {
      result.set(this.mvc.perform(get("/api/c1/callable/10")).andExpect(request().asyncStarted()).andReturn());
    }
 catch (    Exception ex) {
      fail("Failed to execute async request",ex);
    }
  }
);
  backgroundRequest.start();
  assertThat(this.registry.find("http.server.requests").tags("uri","/api/c1/async").timer()).describedAs("Request isn't prematurely recorded as complete").isNull();
  this.callableBarrier.await();
  MockClock.clock(this.registry).add(Duration.ofSeconds(2));
  assertThat(this.registry.get("my.long.request").tags("region","test").longTaskTimer().activeTasks()).isEqualTo(1);
  this.callableBarrier.await();
  backgroundRequest.join();
  this.mvc.perform(asyncDispatch(result.get())).andExpect(status().isOk());
  assertThat(this.registry.get("http.server.requests").tags("status","200").tags("uri","/api/c1/callable/{id}").timer().totalTime(TimeUnit.SECONDS)).isEqualTo(2L);
  assertThat(this.registry.get("my.long.request").tags("region","test").longTaskTimer().activeTasks()).isEqualTo(0);
}
