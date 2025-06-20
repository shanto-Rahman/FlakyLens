@Test public void test_Bytes() throws Exception {
assertArrayEquals("123中华人民共和国".getBytes(),deserialize.readBytes());
fail();
}