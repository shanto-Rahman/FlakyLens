@Test public void shouldRecordErrorResponseMetric(){
  driver.addExpectation(onRequestTo("/bar").withMethod(POST),giveEmptyResponse().withStatus(503));
  unit.post("/bar").dispatch(series(),on(SUCCESSFUL).call(pass())).exceptionally(e -> null).join();
  @Nullable final Timer timer=registry.find("http.outgoing-requests").timer();
  assertThat(timer,is(notNullValue()));
  assertThat(timer.getId().getTag("method"),is("POST"));
  assertThat(timer.getId().getTag("uri"),is("/bar"));
  assertThat(timer.getId().getTag("status"),is("503"));
  assertThat(timer.getId().getTag("clientName"),is("localhost"));
  assertThat(timer.getId().getTag("client"),is("example"));
  assertThat(timer.totalTime(NANOSECONDS),is(greaterThan(0.0)));
}
