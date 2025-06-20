@Test public void testHashCode() throws Exception {
assertEquals(byteString.hashCode(),byteString.hashCode());
assertEquals(byteString.hashCode(),ByteString.decodeHex("0102").hashCode());
}