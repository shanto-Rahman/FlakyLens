@Test public void test_shortArray() throws Exception {
assertArrayEquals(data,(short[])deserialize.readObject());
fail();
}