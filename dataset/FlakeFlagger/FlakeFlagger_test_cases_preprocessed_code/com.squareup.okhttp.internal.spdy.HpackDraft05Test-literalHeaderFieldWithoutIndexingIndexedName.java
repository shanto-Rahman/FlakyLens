/** 
 * http://tools.ietf.org/html/draft-ietf-httpbis-header-compression-05#appendix-E.1.2
 */
@Test public void literalHeaderFieldWithoutIndexingIndexedName() throws IOException {
assertEquals(expectedBytes,bytesOut);
assertEquals(0,hpackReader.headerCount);
assertEquals(headerBlock,hpackReader.getAndReset());
}