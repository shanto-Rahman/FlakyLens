@Test public void asyncRequestThatThrowsUncheckedException() throws Exception {
  MvcResult result=this.mvc.perform(get("/api/c1/completableFutureException")).andExpect(request().asyncStarted()).andReturn();
  assertThat(this.registry.get("my.long.request.exception").longTaskTimer().activeTasks()).isEqualTo(1);
  assertThatExceptionOfType(NestedServletException.class).isThrownBy(() -> this.mvc.perform(asyncDispatch(result))).withRootCauseInstanceOf(RuntimeException.class);
  assertThat(this.registry.get("http.server.requests").tags("uri","/api/c1/completableFutureException").timer().count()).isEqualTo(1);
  assertThat(this.registry.get("my.long.request.exception").longTaskTimer().activeTasks()).isEqualTo(0);
}
