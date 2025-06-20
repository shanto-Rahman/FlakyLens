@Test public void requestOnlyIfCachedWithConditionalResponseCached() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals(2,cache.getRequestCount());
assertEquals(1,cache.getNetworkCount());
assertEquals(0,cache.getHitCount());
}