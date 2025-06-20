@Config(sdk=24) @Test public void completableFutureApi24() throws Exception {
CompletableFuture<String> future=service.endpoint();//IT
assertThat(future.get()).isEqualTo("Hi");
}