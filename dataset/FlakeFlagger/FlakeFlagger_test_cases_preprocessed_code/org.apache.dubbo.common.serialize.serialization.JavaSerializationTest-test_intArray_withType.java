@Test public void test_intArray_withType() throws Exception {
assertArrayEquals(data,(int[])deserialize.readObject(int[].class));
fail();
}