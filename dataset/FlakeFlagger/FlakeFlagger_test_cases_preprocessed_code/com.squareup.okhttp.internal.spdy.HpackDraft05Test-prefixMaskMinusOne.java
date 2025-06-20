@Test public void prefixMaskMinusOne() throws IOException {
assertEquals(31,newReader(byteStream(0)).readInt(31,31));
}