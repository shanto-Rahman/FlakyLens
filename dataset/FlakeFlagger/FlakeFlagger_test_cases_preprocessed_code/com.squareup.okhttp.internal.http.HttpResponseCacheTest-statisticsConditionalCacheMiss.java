@Test public void statisticsConditionalCacheMiss() throws Exception {
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals(1,cache.getRequestCount());
assertEquals(1,cache.getNetworkCount());
assertEquals(0,cache.getHitCount());
assertEquals("B",readAscii(openConnection(server.getUrl("/"))));
assertEquals("C",readAscii(openConnection(server.getUrl("/"))));
assertEquals(3,cache.getRequestCount());
assertEquals(3,cache.getNetworkCount());
assertEquals(0,cache.getHitCount());
}