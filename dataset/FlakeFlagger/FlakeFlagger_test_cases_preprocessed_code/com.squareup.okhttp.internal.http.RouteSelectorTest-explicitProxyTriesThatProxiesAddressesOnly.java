@Test public void explicitProxyTriesThatProxiesAddressesOnly() throws Exception {
assertTrue(routeSelector.hasNext());
assertFalse(routeSelector.hasNext());
dns.assertRequests(proxyAHost);//IT
proxySelector.assertRequests();//IT
}