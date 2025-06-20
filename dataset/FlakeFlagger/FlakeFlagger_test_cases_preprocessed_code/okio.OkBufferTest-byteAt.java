@Test public void byteAt() throws Exception {
assertEquals('a',buffer.getByte(0));
assertEquals('a',buffer.getByte(0));
assertEquals('c',buffer.getByte(buffer.size - 1));
assertEquals('b',buffer.getByte(buffer.size - 2));
assertEquals('b',buffer.getByte(buffer.size - 3));
}