@Test public void readLowerCase() throws Exception {
assertEquals(ByteString.encodeUtf8("ab"),ByteString.read(in,2).toAsciiLowercase());
assertEquals(ByteString.encodeUtf8("c"),ByteString.read(in,1).toAsciiLowercase());
assertEquals(ByteString.EMPTY,ByteString.read(in,0).toAsciiLowercase());
}