@Test public void parseInternal_cacheConfigWithExpiration_returnsConfiguredCacheThatRespectExpiration() throws Exception {
Thread.sleep(2000);
assertNotNull(cacheManager);
assertNotNull(cache);
assertNull(cache.get("foo"));
}