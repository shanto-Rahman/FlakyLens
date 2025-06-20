@Test public void explicitDirectProxy() throws Exception {
assertTrue(routeSelector.hasNext());
assertFalse(routeSelector.hasNext());
dns.assertRequests(uri.getHost());//IT
proxySelector.assertRequests();//IT
}