@Test public void testCachingWorks(){
assertTrue(response.contains("No cache key set."));
assertTrue(response.contains("Cache key is: cacheKeyValue"));
}