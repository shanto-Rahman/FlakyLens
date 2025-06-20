/** 
 * Test that we can interrogate the response when the cache is being populated. http://code.google.com/p/android/issues/detail?id=7787
 */
@Test public void responseCacheCallbackApis() throws Exception {
assertEquals(server.getUrl("/"),response.request().url());
assertEquals(200,response.code());
assertNull(response.body());
assertEquals("5",response.header("Content-Length"));
assertEquals("text/plain",response.header("Content-Type"));
assertEquals("ijk",response.header("fgh"));
cacheCount.incrementAndGet();
assertEquals(body,readAscii(connection));
assertEquals(1,cacheCount.get());
}