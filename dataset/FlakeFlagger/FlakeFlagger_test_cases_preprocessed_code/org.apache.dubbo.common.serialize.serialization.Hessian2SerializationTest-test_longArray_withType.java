@Test public void test_longArray_withType() throws Exception {
assertArrayEquals(data,(long[])deserialize.readObject());
fail();
}