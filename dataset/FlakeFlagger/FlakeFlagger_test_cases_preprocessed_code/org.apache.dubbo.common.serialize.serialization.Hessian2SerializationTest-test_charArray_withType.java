@Test public void test_charArray_withType() throws Exception {
assertArrayEquals(data,(char[])deserialize.readObject(char[].class));
fail();
}