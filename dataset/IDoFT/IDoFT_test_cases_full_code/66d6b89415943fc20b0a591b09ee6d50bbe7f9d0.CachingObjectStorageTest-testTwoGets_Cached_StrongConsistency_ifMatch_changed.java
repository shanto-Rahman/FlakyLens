@Test public void testTwoGets_Cached_StrongConsistency_ifMatch_changed() throws Exception {
  Path directory=Files.createTempDirectory(this.getClass().getSimpleName());
  directory.toFile().deleteOnExit();
  long maximumWeight=CONTENT.length();
  int expireAfterWriteSeconds=getExpireAfterWriteSeconds();
  when(mockClient.getObject(where(r -> r.getIfMatch() != null && r.getRange() == null))).thenAnswer(i -> {
    return GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT.length())).inputStream(new ByteArrayInputStream(CONTENT.getBytes())).eTag("etag1a").__httpStatusCode__(200).build();
  }
);
  when(mockClient.getObject(where(r -> r.getIfMatch().equals("etag1a") && r.getRange() != null && Long.valueOf(0).equals(r.getRange().getStartByte()) && Long.valueOf(0).equals(r.getRange().getEndByte())))).thenThrow(new BmcException(Response.Status.PRECONDITION_FAILED.getStatusCode(),Response.Status.PRECONDITION_FAILED.getReasonPhrase(),"etag doesn't match if-match","request-id"));
  CachingObjectStorage cachingObjectStorageClient=CachingObjectStorage.build(CachingObjectStorage.newConfiguration().client(mockClient).cacheDirectory(directory).maximumWeight(maximumWeight).expireAfterWrite(Duration.ofSeconds(expireAfterWriteSeconds)).build());
  GetObjectRequest request=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object").ifMatch("etag1a").build();
  GetObjectResponse response=cachingObjectStorageClient.getObject(request);
  try {
    cachingObjectStorageClient.getObject(request);
    fail("Should have failed");
  }
 catch (  BmcException e) {
    assertEquals(412,e.getStatusCode());
  }
catch (  Exception e) {
    fail("Should have failed with 412");
  }
  StringWriter sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(response.getInputStream()),sw);
  assertEquals(CONTENT,sw.toString());
  verify(mockClient,times(2)).getObject(any());
  verifyNoMoreInteractions(mockClient);
  assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  cachingObjectStorageClient.cleanUp();
  assertTrue(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  TimeUnit.SECONDS.sleep(expireAfterWriteSeconds);
  cachingObjectStorageClient.cleanUp();
  System.gc();
  Thread.sleep(500);
  assertFalse(((CachingObjectStorage.CachedInputStream)response.getInputStream()).getCachedContentPath().toFile().exists());
  cachingObjectStorageClient.close();
}
