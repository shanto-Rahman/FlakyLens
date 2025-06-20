@Test public void shouldInvokeListenersOnRetryableResult(){
  driver.addExpectation(onRequestTo("/baz"),giveEmptyResponse().withStatus(502));
  driver.addExpectation(onRequestTo("/baz"),giveEmptyResponse());
  unit.get("/baz").call(pass()).join();
  verify(listeners).onRetry(notNull(),notNull(),isNull(),notNull());
}
