@Test public void testTwoDistinctGets_StrongConsistency() throws Exception {
  Path directory=Files.createTempDirectory(this.getClass().getSimpleName());
  directory.toFile().deleteOnExit();
  long maximumWeight=CONTENT.length() + CONTENT2.length();
  int expireAfterWriteSeconds=getExpireAfterWriteSeconds();
  GetObjectRequest request=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object").build();
  GetObjectRequest request2=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object2").build();
  Predicate<GetObjectRequest> lambda1with, lambda1without, lambda2with, lambda2without;
  when(mockClient.getObject(where(lambda1without=r -> request.getObjectName().equals(r.getObjectName()) && r.getIfNoneMatch() == null))).thenAnswer(i -> {
    return GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT.length())).eTag("etag1a").inputStream(new ByteArrayInputStream(CONTENT.getBytes())).__httpStatusCode__(200).build();
  }
);
  when(mockClient.getObject(where(lambda1with=r -> request.getObjectName().equals(r.getObjectName()) && r.getIfNoneMatch() != null))).thenReturn(GetObjectResponse.builder().eTag("etag1a").__httpStatusCode__(Response.Status.NOT_MODIFIED.getStatusCode()).isNotModified(true).inputStream(null).build());
  when(mockClient.getObject(where(lambda2without=r -> request2.getObjectName().equals(r.getObjectName()) && r.getIfNoneMatch() == null))).thenAnswer(i -> {
    return GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT2.length())).eTag("etag2a").inputStream(new ByteArrayInputStream(CONTENT2.getBytes())).__httpStatusCode__(200).build();
  }
);
  when(mockClient.getObject(where(lambda2with=r -> request2.getObjectName().equals(r.getObjectName()) && r.getIfNoneMatch() != null))).thenReturn(GetObjectResponse.builder().eTag("etag2a").__httpStatusCode__(Response.Status.NOT_MODIFIED.getStatusCode()).isNotModified(true).inputStream(null).build());
  CachingObjectStorage cachingObjectStorageClient=CachingObjectStorage.build(CachingObjectStorage.newConfiguration().client(mockClient).cacheDirectory(directory).maximumWeight(maximumWeight).expireAfterWrite(Duration.ofSeconds(expireAfterWriteSeconds)).build());
  GetObjectResponse response=cachingObjectStorageClient.getObject(request);
  GetObjectResponse response2=cachingObjectStorageClient.getObject(request2);
  StringWriter sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  StringWriter sw2=new StringWriter();
  IOUtils.copy(new InputStreamReader(response2.getInputStream()),sw2);
  assertEquals(CONTENT,sw.toString());
  assertEquals(CONTENT2,sw2.toString());
  response=cachingObjectStorageClient.getObject(request);
  response2=cachingObjectStorageClient.getObject(request2);
  sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  sw2=new StringWriter();
  IOUtils.copy(new InputStreamReader(response2.getInputStream()),sw2);
  assertEquals(CONTENT,sw.toString());
  assertEquals(CONTENT2,sw2.toString());
  verify(mockClient,times(1)).getObject(where(lambda1without));
  verify(mockClient,times(1)).getObject(where(lambda1with));
  verify(mockClient,times(1)).getObject(where(lambda2without));
  verify(mockClient,times(1)).getObject(where(lambda2with));
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
