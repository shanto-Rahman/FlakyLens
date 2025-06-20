/** 
 * We had a bug where we weren't closing Gzip streams on redirects. https://github.com/square/okhttp/issues/441
 */
@Test public void gzipWithRedirectAndConnectionReuse() throws Exception {
assertEquals(0,requestA.getSequenceNumber());
assertEquals(1,requestB.getSequenceNumber());
}