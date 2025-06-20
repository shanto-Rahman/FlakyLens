/** 
 * http://tools.ietf.org/html/draft-ietf-httpbis-header-compression-05#appendix-E.1.4
 */
@Test public void readIndexedHeaderFieldFromStaticTableWithoutBuffering() throws IOException {
assertEquals(0,hpackReader.headerCount);
assertEquals(headerEntries(":method","GET"),hpackReader.getAndReset());
}