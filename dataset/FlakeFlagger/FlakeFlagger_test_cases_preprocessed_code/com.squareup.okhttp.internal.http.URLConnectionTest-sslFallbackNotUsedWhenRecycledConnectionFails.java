/** 
 * When a pooled connection fails, don't blame the route. Otherwise pooled connection failures can cause unnecessary SSL fallbacks. https://github.com/square/okhttp/issues/515
 */
@Test public void sslFallbackNotUsedWhenRecycledConnectionFails() throws Exception {
assertEquals("TLSv1",request1.getSslProtocol());
assertEquals("TLSv1",request2.getSslProtocol());
}