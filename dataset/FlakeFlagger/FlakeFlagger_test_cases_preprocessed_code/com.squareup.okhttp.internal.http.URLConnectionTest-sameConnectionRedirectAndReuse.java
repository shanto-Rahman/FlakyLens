/** 
 * Retry redirects if the socket is closed. https://code.google.com/p/android/issues/detail?id=41576
 */
@Test public void sameConnectionRedirectAndReuse() throws Exception {
assertEquals(0,server.takeRequest().getSequenceNumber());
assertEquals(0,server.takeRequest().getSequenceNumber());
}