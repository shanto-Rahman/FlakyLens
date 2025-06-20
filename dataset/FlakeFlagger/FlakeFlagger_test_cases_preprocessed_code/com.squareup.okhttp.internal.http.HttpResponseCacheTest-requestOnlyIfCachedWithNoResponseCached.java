@Test public void requestOnlyIfCachedWithNoResponseCached() throws IOException {
assertEquals(1,cache.getRequestCount());
assertEquals(0,cache.getNetworkCount());
assertEquals(0,cache.getHitCount());
}