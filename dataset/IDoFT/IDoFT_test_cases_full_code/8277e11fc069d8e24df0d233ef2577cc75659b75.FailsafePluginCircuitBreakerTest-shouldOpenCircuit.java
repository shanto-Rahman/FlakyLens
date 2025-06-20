@Test(expected=CircuitBreakerOpenException.class) public void shouldOpenCircuit() throws Throwable {
  driver.addExpectation(onRequestTo("/foo"),giveEmptyResponse().after(800,MILLISECONDS));
  unit.get("/foo").call(pass()).exceptionally(partially(SocketTimeoutException.class,this::ignore)).join();
  try {
    unit.get("/foo").call(pass()).join();
  }
 catch (  final CompletionException e) {
    throw e.getCause();
  }
}
