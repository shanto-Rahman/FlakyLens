@Test public void shouldRecordSuccessResponseMetric(){
  driver.addExpectation(onRequestTo("/foo"),giveEmptyResponse().withStatus(200));
  unit.get("/foo").call(pass()).join();
  @Nullable final Timer timer=registry.find("http.outgoing-requests").timer();
  assertThat(timer,is(notNullValue()));
  assertThat(timer.getId().getTag("method"),is("GET"));
  assertThat(timer.getId().getTag("uri"),is("/foo"));
  assertThat(timer.getId().getTag("status"),is("200"));
  assertThat(timer.getId().getTag("clientName"),is("localhost"));
  assertThat(timer.getId().getTag("client"),is("example"));
  assertThat(timer.totalTime(NANOSECONDS),is(greaterThan(0.0)));
}
