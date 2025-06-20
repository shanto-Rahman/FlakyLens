@Test public void testSendLargeFileHTTPSWithProxy() throws Exception {
  try (SiteToSiteClient client=getDefaultBuilderHTTPS().portName("input-running").httpProxy(new HttpProxy("localhost",proxyServer.getListenAddress().getPort(),null,null)).build()){
    testSendLargeFile(client);
  }
 }
