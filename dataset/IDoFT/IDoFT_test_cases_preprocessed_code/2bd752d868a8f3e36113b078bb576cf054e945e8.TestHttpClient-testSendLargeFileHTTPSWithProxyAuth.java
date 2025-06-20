@Test public void testSendLargeFileHTTPSWithProxyAuth() throws Exception {
try (SiteToSiteClient client=getDefaultBuilderHTTPS().portName("input-running").httpProxy(new HttpProxy("localhost",proxyServerWithAuth.getListenAddress().getPort(),PROXY_USER,PROXY_PASSWORD)).build())//RW
}