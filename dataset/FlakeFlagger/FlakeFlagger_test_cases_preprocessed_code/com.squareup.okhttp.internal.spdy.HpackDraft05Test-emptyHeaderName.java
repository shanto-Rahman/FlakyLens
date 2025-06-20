@Test public void emptyHeaderName() throws IOException {
assertEquals(ByteString.EMPTY,newReader(byteStream(0)).readByteString(true));
assertEquals(ByteString.EMPTY,newReader(byteStream(0)).readByteString(false));
}