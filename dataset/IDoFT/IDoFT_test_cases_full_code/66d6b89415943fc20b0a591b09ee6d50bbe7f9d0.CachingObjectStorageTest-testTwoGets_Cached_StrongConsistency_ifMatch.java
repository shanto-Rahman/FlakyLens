@Test public void testTwoGets_Cached_StrongConsistency_ifMatch() throws Exception {
  Path directory=Files.createTempDirectory(this.getClass().getSimpleName());
  directory.toFile().deleteOnExit();
  long maximumWeight=CONTENT.length();
  int expireAfterWriteSeconds=getExpireAfterWriteSeconds();
  when(mockClient.getObject(where(r -> r.getIfMatch() != null && r.getRange() == null))).thenAnswer(i -> {
    return GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT.length())).inputStream(new ByteArrayInputStream(CONTENT.getBytes())).eTag("etag1a").__httpStatusCode__(200).build();
  }
);
  when(mockClient.getObject(where(r -> r.getIfMatch().equals("etag1a") && r.getRange() != null && Long.valueOf(0).equals(r.getRange().getStartByte()) && Long.valueOf(0).equals(r.getRange().getEndByte())))).thenReturn(GetObjectResponse.builder().eTag("etag1a").__httpStatusCode__(200).inputStream(new ByteArrayInputStream(new byte[]{CONTENT.getBytes()[0]})).build());
  CachingObjectStorage cachingObjectStorageClient=CachingObjectStorage.build(CachingObjectStorage.newConfiguration().client(mockClient).cacheDirectory(directory).maximumWeight(maximumWeight).expireAfterWrite(Duration.ofSeconds(expireAfterWriteSeconds)).build());
  GetObjectRequest request=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object").ifMatch("etag1a").build();
  GetObjectResponse response=cachingObjectStorageClient.getObject(request);
  GetObjectResponse response2=cachingObjectStorageClient.getObject(request);
  StringWriter sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  StringWriter sw2=new StringWriter();
  IOUtils.copy(new InputStreamReader(response2.getInputStream()),sw2);
  assertEquals(CONTENT,sw.toString());
  assertEquals(CONTENT,sw2.toString());
  verify(mockClient,times(2)).getObject(any());
  verifyNoMoreInteractions(mockClient);
  assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
  assertEquals(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath(),((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath());
  cachingObjectStorageClient.cleanUp();
  assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  assertTrue(((CachingObjectStorage.CachedInputStream)response2.getInputStream()).getCachedContentPath().toFile().exists());
  TimeUnit.SECONDS.sleep(expireAfterWriteSeconds);
  cachingObjectStorageClient.cleanUp();
  System.gc();
  Thread.sleep(500);
  assertFalse(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  cachingObjectStorageClient.close();
}
