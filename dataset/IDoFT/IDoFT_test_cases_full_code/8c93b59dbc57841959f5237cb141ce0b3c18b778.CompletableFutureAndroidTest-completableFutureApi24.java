@Config(sdk=24) @Test public void completableFutureApi24() throws Exception {
  server.enqueue(new MockResponse().setBody("Hi"));
  CompletableFuture<String> future=service.endpoint();
  assertThat(future.get()).isEqualTo("Hi");
}
