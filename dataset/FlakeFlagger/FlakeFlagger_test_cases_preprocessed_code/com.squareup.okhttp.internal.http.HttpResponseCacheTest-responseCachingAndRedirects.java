@Test public void responseCachingAndRedirects() throws Exception {
assertEquals("ABC",readAscii(connection));
assertEquals("ABC",readAscii(connection));
assertEquals(4,cache.getRequestCount());
assertEquals(2,cache.getNetworkCount());
assertEquals(2,cache.getHitCount());
}