@Test public void testTwoGetsCached() throws Exception {
  Path directory=Files.createTempDirectory(this.getClass().getSimpleName());
  directory.toFile().deleteOnExit();
  int expireSeconds=3;
  getExpireAfterWriteSeconds();
  when(mockClient.getObject(any())).thenAnswer(i -> {
    return GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT.length())).inputStream(new ByteArrayInputStream(CONTENT.getBytes())).eTag("etag1").build();
  }
);
  CachingObjectStorage cachingObjectStorageClient=CachingObjectStorage.build(CachingObjectStorage.newConfiguration().client(mockClient).cacheDirectory(directory).expireAfterWrite(Duration.ofSeconds(expireSeconds)).consistencyPolicy(new NoOpConsistencyPolicy()).build());
  GetObjectRequest request=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object").build();
  GetObjectResponse response=cachingObjectStorageClient.getObject(request);
  StringWriter sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  assertEquals(CONTENT,sw.toString());
  Path cachedContentPath=((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath();
  GetObjectResponse response2=cachingObjectStorageClient.getObject(request);
  StringWriter sw2=new StringWriter();
  IOUtils.copy(new InputStreamReader(response2.getInputStream()),sw2);
  assertEquals(CONTENT,sw2.toString());
  Path cachedContentPath2=((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath();
  assertTrue(cachingObjectStorageClient.getEvictedButNotDeleted().isEmpty());
  LOG.debug("Trying to force the cache to be cleared");
  cachingObjectStorageClient.cleanUp();
  System.gc();
  Thread.sleep(5000);
  System.gc();
  LOG.debug("Trying to force the cache to be cleared");
  cachingObjectStorageClient.cleanUp();
  System.gc();
  Thread.sleep(5000);
  System.gc();
  Set<Path> evictedButNotDeleted=cachingObjectStorageClient.getEvictedButNotDeleted();
  assertTrue(evictedButNotDeleted.isEmpty());
  assertFalse(cachedContentPath.toFile().exists());
  assertFalse(cachedContentPath2.toFile().exists());
  verify(mockClient,times(1)).getObject(any());
  verifyNoMoreInteractions(mockClient);
  cachingObjectStorageClient.close();
}
