@Test public void zero() throws IOException {
assertEquals(0,newReader(byteStream()).readInt(0,31));
}