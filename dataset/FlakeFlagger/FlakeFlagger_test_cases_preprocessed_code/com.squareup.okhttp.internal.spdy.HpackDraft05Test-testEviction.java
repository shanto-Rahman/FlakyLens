/** 
 * Oldest entries are evicted to support newer ones. 
 */
@Test public void testEviction() throws IOException {
assertEquals(2,hpackReader.headerCount);
assertEquals(headerEntries("custom-bar","custom-header","custom-baz","custom-header"),hpackReader.getAndReset());
assertEquals(1,hpackReader.headerCount);
}