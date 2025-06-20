@Test public void testSendSuccessWithProxy() throws Exception {
  try (final SiteToSiteClient client=getDefaultBuilder().portName("input-running").httpProxy(new HttpProxy("localhost",proxyServer.getListenAddress().getPort(),null,null)).build()){
    testSend(client);
  }
 }
