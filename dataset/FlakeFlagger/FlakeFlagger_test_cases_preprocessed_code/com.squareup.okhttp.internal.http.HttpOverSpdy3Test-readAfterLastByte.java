@Test public void readAfterLastByte() throws Exception {
assertEquals("ABC",readAscii(in,3));
assertEquals(-1,in.read());
assertEquals(-1,in.read());
}