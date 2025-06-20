@Test public void skip() throws Exception {
assertEquals('b',buffer.readByte() & 0xff);
assertEquals('b',buffer.readByte() & 0xff);
assertEquals(0,buffer.size());
}