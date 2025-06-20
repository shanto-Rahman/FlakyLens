/** 
 * We've had a bug where we forget the HTTP response when we see response code 401. This causes a new HTTP request to be issued for every call into the URLConnection.
 */
@Test public void unauthorizedResponseHandling() throws IOException {
assertEquals(401,conn.getResponseCode());
assertEquals(401,conn.getResponseCode());
assertEquals(401,conn.getResponseCode());
assertEquals(1,server.getRequestCount());
}