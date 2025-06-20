@Test public void concat(){
assertEquals(ByteString.of(),ByteString.concat());
assertEquals(ByteString.of(),ByteString.concat(ByteString.EMPTY));
assertEquals(ByteString.of(),ByteString.concat(ByteString.EMPTY,ByteString.EMPTY));
assertEquals(foo,ByteString.concat(foo));
assertEquals(ByteString.encodeUtf8("foobar"),ByteString.concat(foo,bar));
}