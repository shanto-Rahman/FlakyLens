@Test public void testSendLargeFileHTTPWithProxy() throws Exception {
  try (SiteToSiteClient client=getDefaultBuilder().portName("input-running").httpProxy(new HttpProxy("localhost",proxyServer.getListenAddress().getPort(),null,null)).build()){
    testSendLargeFile(client);
  }
 }
