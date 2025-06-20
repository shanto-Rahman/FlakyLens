@Test public void testPrepopulateCache() throws Exception {
assertEquals(CONTENT,sw.toString());
assertEquals(response.getContentLength(),cacheResponse.getContentLength());
assertEquals(response.getETag(),cacheResponse.getETag());
assertEquals(response.get__httpStatusCode__(),cacheResponse.get__httpStatusCode__());
}