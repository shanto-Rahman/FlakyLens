@Test public void shouldUseBackupRequest() throws Throwable {
  driver.addExpectation(onRequestTo("/bar"),giveEmptyResponse().after(2,SECONDS));
  driver.addExpectation(onRequestTo("/bar"),giveEmptyResponse());
  unit.get("/bar").call(pass()).get(1500,TimeUnit.MILLISECONDS);
}
