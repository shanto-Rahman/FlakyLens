@Test public void testTempUnavailableServlet() throws IOException, InterruptedException {
  TestHttpClient client=new TestHttpClient();
  try {
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerURL() + "/servletContext/t");
    HttpResponse result=client.execute(get);
    Assert.assertEquals(StatusCodes.SERVICE_UNAVAILABLE,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
    Thread.sleep(1001);
    get=new HttpGet(DefaultServer.getDefaultServerURL() + "/servletContext/t");
    result=client.execute(get);
    Assert.assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
    HttpClientUtils.readResponse(result);
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
