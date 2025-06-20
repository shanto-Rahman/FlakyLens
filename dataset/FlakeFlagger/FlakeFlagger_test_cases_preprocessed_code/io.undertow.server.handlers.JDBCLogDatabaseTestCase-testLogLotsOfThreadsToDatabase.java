@Test public void testLogLotsOfThreadsToDatabase() throws IOException, InterruptedException, ExecutionException, SQLException {
ExecutorService executor=Executors.newFixedThreadPool(NUM_THREADS);
futures.add(executor.submit(new Runnable(){
  @Override public void run(){
    TestHttpClient client=new TestHttpClient();
    try {
      for (int i=0; i < NUM_REQUESTS; ++i) {
        HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path");
        HttpResponse result=client.execute(get);
        Assert.assertEquals(200,result.getStatusLine().getStatusCode());
        final String response=HttpClientUtils.readResponse(result);
        Assert.assertEquals("Hello",response);
      }
    }
 catch (    IOException e) {
      throw new RuntimeException(e);
    }
 finally {
      client.getConnectionManager().shutdown();
    }
  }
}
));
Assert.assertEquals(200,result.getStatusLine().getStatusCode());
Assert.assertEquals("Hello",response);
future.get();
executor.shutdown();
Assert.assertEquals(resultDatabase.getInt(1),NUM_REQUESTS * NUM_THREADS);
if (statement != null) {
}
if (conn != null) {
}
}