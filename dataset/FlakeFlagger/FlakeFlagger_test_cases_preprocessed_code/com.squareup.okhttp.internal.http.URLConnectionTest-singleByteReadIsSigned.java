@Test public void singleByteReadIsSigned() throws IOException {
assertEquals(254,in.read());
assertEquals(255,in.read());
assertEquals(-1,in.read());
}