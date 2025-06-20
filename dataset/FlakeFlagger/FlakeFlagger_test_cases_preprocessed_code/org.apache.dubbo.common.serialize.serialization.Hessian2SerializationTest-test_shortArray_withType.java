@Test public void test_shortArray_withType() throws Exception {
assertArrayEquals(data,(short[])deserialize.readObject(short[].class));
fail();
}