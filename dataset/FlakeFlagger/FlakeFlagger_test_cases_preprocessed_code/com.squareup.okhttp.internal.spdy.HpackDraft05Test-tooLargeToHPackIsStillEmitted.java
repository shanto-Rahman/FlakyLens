/** 
 * HPACK has a max header table size, which can be smaller than the max header message. Ensure the larger header content is not lost.
 */
@Test public void tooLargeToHPackIsStillEmitted() throws IOException {
assertEquals(0,hpackReader.headerCount);
assertEquals(headerEntries("custom-key","custom-header"),hpackReader.getAndReset());
}