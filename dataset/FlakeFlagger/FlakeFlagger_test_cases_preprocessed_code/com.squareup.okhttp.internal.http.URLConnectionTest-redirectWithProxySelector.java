@Test public void redirectWithProxySelector() throws Exception {
assertEquals(Arrays.asList(server.getUrl("/a").toURI(),server2.getUrl("/b").toURI()),proxySelectionRequests);
}