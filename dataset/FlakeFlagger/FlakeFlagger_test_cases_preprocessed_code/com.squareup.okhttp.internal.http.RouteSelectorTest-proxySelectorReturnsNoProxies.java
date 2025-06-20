@Test public void proxySelectorReturnsNoProxies() throws Exception {
assertTrue(routeSelector.hasNext());
assertFalse(routeSelector.hasNext());
dns.assertRequests(uri.getHost());//IT
proxySelector.assertRequests(uri);//IT
}