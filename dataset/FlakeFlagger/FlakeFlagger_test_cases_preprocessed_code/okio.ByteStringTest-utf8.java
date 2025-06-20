@Test public void utf8() throws Exception {
assertTrue(byteString.equals(ByteString.of(bronzeHorseman.getBytes(Util.UTF_8))));
assertEquals(byteString.utf8(),bronzeHorseman);
}