@Test public void test_longArray() throws Exception {
assertArrayEquals(data,(long[])deserialize.readObject());
fail();
}