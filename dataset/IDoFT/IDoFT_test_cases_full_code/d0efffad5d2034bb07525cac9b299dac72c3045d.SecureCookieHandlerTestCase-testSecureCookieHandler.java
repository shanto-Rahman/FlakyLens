@Test public void testSecureCookieHandler() throws IOException, GeneralSecurityException {
  DefaultServer.setRootHandler(new SecureCookieHandler(new HttpHandler(){
    @Override public void handleRequest(    final HttpServerExchange exchange) throws Exception {
      exchange.getResponseCookies().put("foo",new CookieImpl("foo","bar"));
    }
  }
));
  DefaultServer.startSSLServer();
  TestHttpClient client=new TestHttpClient();
  client.setSSLContext(DefaultServer.getClientSSLContext());
  try {
    HttpGet get=new HttpGet(DefaultServer.getDefaultServerSSLAddress());
    HttpResponse result=client.execute(get);
    Assert.assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
    Header header=result.getFirstHeader("set-cookie");
    Assert.assertEquals("foo=bar; secure",header.getValue());
    FileUtils.readFile(result.getEntity().getContent());
    get=new HttpGet(DefaultServer.getDefaultServerURL());
    result=client.execute(get);
    Assert.assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
    header=result.getFirstHeader("set-cookie");
    Assert.assertEquals("foo=bar",header.getValue());
  }
  finally {
    client.getConnectionManager().shutdown();
    DefaultServer.stopSSLServer();
  }
}
