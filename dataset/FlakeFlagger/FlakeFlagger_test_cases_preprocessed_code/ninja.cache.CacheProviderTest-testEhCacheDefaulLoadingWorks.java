@Test public void testEhCacheDefaulLoadingWorks(){
assertTrue(cacheProvider.get() instanceof CacheEhCacheImpl);
}