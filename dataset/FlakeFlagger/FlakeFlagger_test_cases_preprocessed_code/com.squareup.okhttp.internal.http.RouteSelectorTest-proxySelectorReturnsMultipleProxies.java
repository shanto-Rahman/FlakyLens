@Test public void proxySelectorReturnsMultipleProxies() throws Exception {
proxySelector.assertRequests(uri);//IT
assertTrue(routeSelector.hasNext());
dns.assertRequests(proxyAHost);//IT
assertTrue(routeSelector.hasNext());
dns.assertRequests(proxyBHost);//IT
assertTrue(routeSelector.hasNext());
dns.assertRequests(uriHost);//IT
assertFalse(routeSelector.hasNext());
}