@Test public void testTwoDistinctGets_StrongConsistency_ETagChanges() throws Exception {
  Path directory=Files.createTempDirectory(this.getClass().getSimpleName());
  directory.toFile().deleteOnExit();
  long maximumWeight=2 * (CONTENT.length() + CONTENT2.length());
  int expireAfterWriteSeconds=getExpireAfterWriteSeconds();
  GetObjectRequest request=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object").build();
  GetObjectRequest request2=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object2").build();
  Predicate<GetObjectRequest> lambda, lambda2;
  when(mockClient.getObject(where(lambda=r -> request.getObjectName().equals(r.getObjectName())))).thenAnswer(new Answer<GetObjectResponse>(){
    int count=0;
    @Override public GetObjectResponse answer(    InvocationOnMock invocationOnMock) throws Throwable {
      return GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT.length())).eTag((++count == 1) ? "etag1a" : "etag1b").inputStream(new ByteArrayInputStream(CONTENT.getBytes())).__httpStatusCode__(200).build();
    }
  }
);
  when(mockClient.getObject(where(lambda2=r -> request2.getObjectName().equals(r.getObjectName())))).thenAnswer(i -> {
    return GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT2.length())).eTag("etag2a").inputStream(new ByteArrayInputStream(CONTENT2.getBytes())).__httpStatusCode__(200).build();
  }
);
  CachingObjectStorage cachingObjectStorageClient=CachingObjectStorage.build(CachingObjectStorage.newConfiguration().client(mockClient).cacheDirectory(directory).maximumWeight(maximumWeight).expireAfterWrite(Duration.ofSeconds(expireAfterWriteSeconds)).aggressiveCacheGarbageCollection(500).build());
  GetObjectResponse response=cachingObjectStorageClient.getObject(request);
  GetObjectResponse response2=cachingObjectStorageClient.getObject(request2);
  StringWriter sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  StringWriter sw2=new StringWriter();
  IOUtils.copy(new InputStreamReader(response2.getInputStream()),sw2);
  assertEquals(CONTENT,sw.toString());
  assertEquals(CONTENT2,sw2.toString());
  LOG.info("Second read of both");
  response=cachingObjectStorageClient.getObject(request);
  response2=cachingObjectStorageClient.getObject(request2);
  sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  sw2=new StringWriter();
  IOUtils.copy(new InputStreamReader(response2.getInputStream()),sw2);
  assertEquals(CONTENT,sw.toString());
  assertEquals(CONTENT2,sw2.toString());
  LOG.info("Third read of both");
  response=cachingObjectStorageClient.getObject(request);
  response2=cachingObjectStorageClient.getObject(request2);
  sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  sw2=new StringWriter();
  IOUtils.copy(new InputStreamReader(response2.getInputStream()),sw2);
  assertEquals(CONTENT,sw.toString());
  assertEquals(CONTENT2,sw2.toString());
  verify(mockClient,times(3)).getObject(where(lambda));
  verify(mockClient,times(3)).getObject(where(lambda2));
  verifyNoMoreInteractions(mockClient);
  assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
  assertNotEquals(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath(),((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath());
  cachingObjectStorageClient.cleanUp();
  assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
  TimeUnit.SECONDS.sleep(expireAfterWriteSeconds);
  cachingObjectStorageClient.cleanUp();
  System.gc();
  Thread.sleep(500);
  assertFalse(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  assertFalse(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
  cachingObjectStorageClient.close();
}
