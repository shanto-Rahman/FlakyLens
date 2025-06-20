/** 
 * http://tools.ietf.org/html/draft-ietf-httpbis-header-compression-05#appendix-E.1.1
 */
@Test public void readLiteralHeaderFieldWithIndexing() throws IOException {
assertEquals(1,hpackReader.headerCount);
assertEquals(55,hpackReader.headerTableByteCount);
assertEquals(headerEntries("custom-key","custom-header"),hpackReader.getAndReset());
}