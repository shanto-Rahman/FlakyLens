@Test public void conditionalHitUpdatesCache() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals(null,connection1.getHeaderField("Allow"));
assertEquals(HttpURLConnection.HTTP_OK,connection2.getResponseCode());
assertEquals("A",readAscii(connection2));
assertEquals("GET, HEAD",connection2.getHeaderField("Allow"));
assertEquals("A",readAscii(connection3));
assertEquals("GET, HEAD",connection3.getHeaderField("Allow"));
assertEquals(2,server.getRequestCount());
}