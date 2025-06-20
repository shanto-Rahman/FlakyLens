@Test public void callIt() throws ExecutionException, InterruptedException {
assertEquals("resp",ref.justRespond().join());
}