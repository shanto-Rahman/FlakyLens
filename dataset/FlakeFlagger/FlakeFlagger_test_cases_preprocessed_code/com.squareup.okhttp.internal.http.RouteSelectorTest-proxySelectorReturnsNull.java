@Test public void proxySelectorReturnsNull() throws Exception {
proxySelector.assertRequests(uri);//IT
assertTrue(routeSelector.hasNext());
dns.assertRequests(uriHost);//IT
assertFalse(routeSelector.hasNext());
}