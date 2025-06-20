@Test public void test_UtfString() throws Exception {
assertEquals("123中华人民共和国",deserialize.readUTF());
fail();
}