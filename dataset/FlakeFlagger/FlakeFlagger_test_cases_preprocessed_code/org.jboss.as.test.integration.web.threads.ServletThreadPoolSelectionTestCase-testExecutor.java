@Test public void testExecutor() throws Exception {
ExecutorService executor=Executors.newFixedThreadPool(10);
results.add(executor.submit(new Callable<Object>(){
  @Override public Object call() throws Exception {
    HttpRequest.get(url.toExternalForm() + "/race",10,SECONDS);
    return null;
  }
}
));
res.get();
assertEquals("100",result);
executor.shutdown();
}