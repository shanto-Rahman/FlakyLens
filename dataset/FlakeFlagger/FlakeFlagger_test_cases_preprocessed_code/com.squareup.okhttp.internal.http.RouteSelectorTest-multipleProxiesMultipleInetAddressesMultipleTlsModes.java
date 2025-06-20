@Test public void multipleProxiesMultipleInetAddressesMultipleTlsModes() throws Exception {
dns.assertRequests(proxyAHost);//IT
dns.assertRequests(proxyBHost);//IT
dns.assertRequests(uriHost);//IT
assertFalse(routeSelector.hasNext());
}