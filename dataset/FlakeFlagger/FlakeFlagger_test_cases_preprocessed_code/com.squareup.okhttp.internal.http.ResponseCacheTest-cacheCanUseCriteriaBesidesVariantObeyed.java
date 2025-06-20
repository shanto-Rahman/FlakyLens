/** 
 * Confirms the cache implementation may determine the criteria for caching. In real caches this would be the "Vary" headers.
 */
@Test public void cacheCanUseCriteriaBesidesVariantObeyed() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals("A",readAscii(connection2));
assertEquals(1,server.getRequestCount());
assertEquals("B",readAscii(connection3));
assertEquals(2,server.getRequestCount());
assertEquals("A",readAscii(connection4));
assertEquals(2,server.getRequestCount());
}