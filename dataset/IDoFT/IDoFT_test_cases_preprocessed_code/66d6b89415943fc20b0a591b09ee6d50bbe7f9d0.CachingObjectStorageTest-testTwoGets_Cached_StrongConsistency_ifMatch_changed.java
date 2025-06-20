@Test public void testTwoGets_Cached_StrongConsistency_ifMatch_changed() throws Exception {
fail("Should have failed");
assertEquals(412,e.getStatusCode());
fail("Should have failed with 412");
assertEquals(CONTENT,sw.toString());
assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
TimeUnit.SECONDS.sleep(expireAfterWriteSeconds);
Thread.sleep(500);
assertFalse(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
}