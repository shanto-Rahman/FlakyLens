@Test public void responsesAreCached() throws IOException {
assertEquals(1,cache.getRequestCount());
assertEquals(1,cache.getNetworkCount());
assertEquals(0,cache.getHitCount());
assertEquals(3,cache.getRequestCount());
assertEquals(1,cache.getNetworkCount());
assertEquals(2,cache.getHitCount());
}