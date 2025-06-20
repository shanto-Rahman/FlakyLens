@Test public void simpleFileStressTest() throws IOException, ExecutionException, InterruptedException, URISyntaxException {
ExecutorService executor=Executors.newFixedThreadPool(NUM_THREADS);
File rootPath=new File(getClass().getResource("page.html").toURI()).getParentFile();//RO
futures.add(executor.submit(new Runnable(){
  @Override public void run(){
    TestHttpClient client=new TestHttpClient();
    try {
      for (int i=0; i < NUM_REQUESTS; ++i) {
        HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/path/page.html");
        HttpResponse result=client.execute(get);
        Assert.assertEquals(200,result.getStatusLine().getStatusCode());
        final String response=HttpClientUtils.readResponse(result);
        Assert.assertTrue(response,response.contains("A web page"));
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
Assert.assertTrue(response,response.contains("A web page"));
future.get();
executor.shutdown();
}