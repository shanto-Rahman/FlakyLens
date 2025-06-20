@Test public void testTwoGetsCached() throws Exception {
assertEquals(CONTENT,sw.toString());
assertEquals(CONTENT,sw2.toString());
assertTrue(cachingObjectStorageClient.getEvictedButNotDeleted().isEmpty());
Thread.sleep(5000);
Thread.sleep(5000);
assertTrue(evictedButNotDeleted.isEmpty());
assertFalse(cachedContentPath.toFile().exists());
assertFalse(cachedContentPath2.toFile().exists());
}