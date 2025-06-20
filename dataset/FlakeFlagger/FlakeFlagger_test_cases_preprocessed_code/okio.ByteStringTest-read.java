@Test public void read() throws Exception {
assertEquals(ByteString.decodeHex("6162"),ByteString.read(in,2));
assertEquals(ByteString.decodeHex("63"),ByteString.read(in,1));
assertEquals(ByteString.of(),ByteString.read(in,0));
}