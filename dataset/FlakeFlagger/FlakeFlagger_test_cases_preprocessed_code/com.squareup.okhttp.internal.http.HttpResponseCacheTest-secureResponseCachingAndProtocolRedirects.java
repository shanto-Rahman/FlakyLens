/** 
 * We've had bugs where caching and cross-protocol redirects yield class cast exceptions internal to the cache because we incorrectly assumed that HttpsURLConnection was always HTTPS and HttpURLConnection was always HTTP; in practice redirects mean that each can do either. https://github.com/square/okhttp/issues/214
 */
@Test public void secureResponseCachingAndProtocolRedirects() throws IOException {
assertEquals("ABC",readAscii(connection1));
assertEquals("ABC",readAscii(connection2));
assertEquals(4,cache.getRequestCount());
assertEquals(2,cache.getHitCount());
}