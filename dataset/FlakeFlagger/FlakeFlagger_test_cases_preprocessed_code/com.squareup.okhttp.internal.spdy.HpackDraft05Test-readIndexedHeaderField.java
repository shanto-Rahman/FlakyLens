/** 
 * http://tools.ietf.org/html/draft-ietf-httpbis-header-compression-05#appendix-E.1.3
 */
@Test public void readIndexedHeaderField() throws IOException {
assertEquals(1,hpackReader.headerCount);
assertEquals(42,hpackReader.headerTableByteCount);
assertEquals(headerEntries(":method","GET"),hpackReader.getAndReset());
}