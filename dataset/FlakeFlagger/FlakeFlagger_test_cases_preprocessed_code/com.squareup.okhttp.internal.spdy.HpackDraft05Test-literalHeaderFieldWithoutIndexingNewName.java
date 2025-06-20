/** 
 * Literal Header Field without Indexing - New Name
 */
@Test public void literalHeaderFieldWithoutIndexingNewName() throws IOException {
assertEquals(expectedBytes,bytesOut);
assertEquals(0,hpackReader.headerCount);
assertEquals(headerBlock,hpackReader.getAndReset());
}