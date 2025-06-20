@Test public void testMemcachedLoadingWorks(){
assertTrue(cacheProvider.get() instanceof CacheMemcachedImpl);
}