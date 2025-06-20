/** 
 * http://tools.ietf.org/html/draft-ietf-httpbis-header-compression-05#section-3.2.1
 */
@Test public void toggleIndex() throws IOException {
assertEquals(1,hpackReader.headerCount);
assertEquals(42,hpackReader.headerTableByteCount);
assertTrue(hpackReader.getAndReset().isEmpty());
}