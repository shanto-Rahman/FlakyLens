@Test(timeout=1500) public void shouldRetryOnDemandWithDynamicDelay(){
  driver.addExpectation(onRequestTo("/baz"),giveEmptyResponse().withStatus(503).withHeader("Retry-After","1"));
  driver.addExpectation(onRequestTo("/baz"),giveEmptyResponse());
  atLeast(Duration.ofSeconds(1),() -> unit.get("/baz").dispatch(series(),on(SUCCESSFUL).call(pass()),anySeries().dispatch(status(),on(HttpStatus.SERVICE_UNAVAILABLE).call(retry()))).join());
}
