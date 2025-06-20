@Test public void headerName() throws IOException {
assertEquals("foo",newReader(byteStream(3,'F','o','o')).readByteString(true).utf8());
}