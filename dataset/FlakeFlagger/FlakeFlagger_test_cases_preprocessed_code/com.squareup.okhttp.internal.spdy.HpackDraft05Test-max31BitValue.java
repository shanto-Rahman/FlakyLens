@Test public void max31BitValue() throws IOException {
assertEquals(0x7fffffff,newReader(byteStream(224,255,255,255,7)).readInt(31,31));
}