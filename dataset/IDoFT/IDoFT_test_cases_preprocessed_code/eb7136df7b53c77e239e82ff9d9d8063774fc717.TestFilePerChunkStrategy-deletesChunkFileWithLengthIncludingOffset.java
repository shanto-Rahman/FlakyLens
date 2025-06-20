/** 
 * Tests that "new datanode" can delete chunks written to "old datanode" by "new client" (ie. where chunk file accidentally created with {@code size = chunk offset + chunk length}, instead of only chunk length).
 */
@Test public void deletesChunkFileWithLengthIncludingOffset() throws Exception {
assertTrue(file.exists());
assertEquals(offset + chunkInfo.getLen(),file.length());
assertFalse(file.exists());
}