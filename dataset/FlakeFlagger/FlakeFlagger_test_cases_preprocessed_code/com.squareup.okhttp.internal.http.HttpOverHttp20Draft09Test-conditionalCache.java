@Test public void conditionalCache() throws IOException {
assertEquals(1,cache.getRequestCount());
assertEquals(1,cache.getNetworkCount());
assertEquals(0,cache.getHitCount());
assertEquals(2,cache.getRequestCount());
assertEquals(2,cache.getNetworkCount());
assertEquals(1,cache.getHitCount());
}