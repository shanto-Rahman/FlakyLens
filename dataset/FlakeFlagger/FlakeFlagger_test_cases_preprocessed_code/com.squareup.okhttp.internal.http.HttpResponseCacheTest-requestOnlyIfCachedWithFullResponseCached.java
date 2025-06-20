@Test public void requestOnlyIfCachedWithFullResponseCached() throws IOException {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(connection));
assertEquals(2,cache.getRequestCount());
assertEquals(1,cache.getNetworkCount());
assertEquals(1,cache.getHitCount());
}