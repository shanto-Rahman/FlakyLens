@Test public void testPrepopulateCache() throws Exception {
  Path directory=Files.createTempDirectory(this.getClass().getSimpleName());
  directory.toFile().deleteOnExit();
  long maximumWeight=CONTENT.length();
  int expireAfterWriteSeconds=getExpireAfterWriteSeconds();
  CachingObjectStorage cachingObjectStorageClient=CachingObjectStorage.build(CachingObjectStorage.newConfiguration().client(mockClient).cacheDirectory(directory).consistencyPolicy(new NoOpConsistencyPolicy()).maximumWeight(maximumWeight).expireAfterWrite(Duration.ofSeconds(expireAfterWriteSeconds)).build());
  GetObjectResponse response=GetObjectResponse.builder().contentLength(Long.valueOf(CONTENT.length())).inputStream(new ByteArrayInputStream(CONTENT.getBytes())).eTag("etag").__httpStatusCode__(200).build();
  GetObjectRequest request=GetObjectRequest.builder().namespaceName("namespace").bucketName("bucket").objectName("object").build();
  cachingObjectStorageClient.prepopulateCache(request,response);
  GetObjectResponse cacheResponse=cachingObjectStorageClient.getObject(request);
  StringWriter sw=new StringWriter();
  IOUtils.copy(new InputStreamReader(cacheResponse.getInputStream()),sw);
  assertEquals(CONTENT,sw.toString());
  assertEquals(response.getContentLength(),cacheResponse.getContentLength());
  assertEquals(response.getETag(),cacheResponse.getETag());
  assertEquals(response.get__httpStatusCode__(),cacheResponse.get__httpStatusCode__());
}
