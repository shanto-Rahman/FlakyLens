@Test public void testSendSuccessWithProxyAuth() throws Exception {
try (final SiteToSiteClient client=getDefaultBuilder().portName("input-running").httpProxy(new HttpProxy("localhost",proxyServerWithAuth.getListenAddress().getPort(),PROXY_USER,PROXY_PASSWORD)).build())//RW
}