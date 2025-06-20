@Test public void testTwoGets_Cached() throws Exception {
assertEquals(CONTENT,sw.toString());
assertEquals(CONTENT,sw2.toString());
assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
assertEquals(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath(),((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath());
assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
TimeUnit.SECONDS.sleep(expireAfterWriteSeconds);
Thread.sleep(500);
assertFalse(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
}