@Test public void noException() throws ExecutionException, InterruptedException {
assertEquals("resp",ref.justRespond().join());
}