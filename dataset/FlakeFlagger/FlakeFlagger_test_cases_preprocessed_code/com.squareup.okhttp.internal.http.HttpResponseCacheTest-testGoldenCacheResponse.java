/** 
 * Old implementations of OkHttp's response cache wrote header fields like ":status: 200 OK". This broke our cached response parser because it split on the first colon. This regression test exists to help us read these old bad cache entries. https://github.com/square/okhttp/issues/227
 */
@Test public void testGoldenCacheResponse() throws Exception {
assertEquals(entryBody,readAscii(connection));
assertEquals("3",connection.getHeaderField("Content-Length"));
assertEquals("foo",connection.getHeaderField("etag"));
}