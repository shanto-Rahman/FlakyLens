@Test public void huffmanDecodingSupported() throws IOException {
assertEquals(1,hpackReader.headerCount);
assertEquals(52,hpackReader.headerTableByteCount);
}