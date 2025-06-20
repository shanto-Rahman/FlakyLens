@Test(expected=SocketTimeoutException.class) public void shouldNotRetryNonIdempotentMethod() throws Throwable {
  driver.addExpectation(onRequestTo("/foo").withMethod(POST),giveEmptyResponse().after(800,MILLISECONDS));
  try {
    unit.post("/foo").call(pass()).join();
  }
 catch (  final CompletionException e) {
    throw e.getCause();
  }
}
