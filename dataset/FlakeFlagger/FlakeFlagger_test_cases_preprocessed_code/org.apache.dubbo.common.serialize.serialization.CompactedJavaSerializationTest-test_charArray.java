@Test public void test_charArray() throws Exception {
assertArrayEquals(data,(char[])deserialize.readObject());
fail();
}