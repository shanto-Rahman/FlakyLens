/** 
 * Equivalent to    {@link HttpResponseCacheTest#conditionalHitUpdatesCache()} , except a Java standard cache has no means to update the headers for an existing entry so the behavior is different.
 */
@Test public void conditionalHitDoesNotUpdateCache() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals(null,connection1.getHeaderField("Allow"));
assertEquals(HttpURLConnection.HTTP_OK,connection2.getResponseCode());
assertEquals("A",readAscii(connection2));
assertEquals("GET, HEAD",connection2.getHeaderField("Allow"));
assertEquals("B",readAscii(connection3));
assertEquals("B",readAscii(connection4));
assertEquals(3,server.getRequestCount());
}