@Test public void testTwoDistinctGets_StrongConsistency_ETagChanges() throws Exception {
assertEquals(CONTENT,sw.toString());
assertEquals(CONTENT2,sw2.toString());
assertEquals(CONTENT,sw.toString());
assertEquals(CONTENT2,sw2.toString());
assertEquals(CONTENT,sw.toString());
assertEquals(CONTENT2,sw2.toString());
assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
TimeUnit.SECONDS.sleep(expireAfterWriteSeconds);
Thread.sleep(500);
assertFalse(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
assertFalse(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
}