@Test public void proxySelectorDirectConnectionsAreSkipped() throws Exception {
proxySelector.assertRequests(uri);//IT
assertTrue(routeSelector.hasNext());
dns.assertRequests(uriHost);//IT
assertFalse(routeSelector.hasNext());
}