@Test public void testJCacheGetExpired() throws Exception {
Thread.sleep(10);
assertNull(cache.get("testKey"));
}