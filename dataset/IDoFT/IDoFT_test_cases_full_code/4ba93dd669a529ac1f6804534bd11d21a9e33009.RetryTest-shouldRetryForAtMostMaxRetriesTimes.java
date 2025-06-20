@Test void shouldRetryForAtMostMaxRetriesTimes(){
  server.expect(times(3),requestTo("http://retry-test")).andRespond(withServerError());
  assertThrows(CompletionException.class,() -> retryClient.get().dispatch(series(),on(SERVER_ERROR).call(retry())).join());
  server.verify();
}
