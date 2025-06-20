@Test public void test_floatArray_withType() throws Exception {
assertArrayEquals(data,(float[])deserialize.readObject(float[].class),0.0001F);
fail();
}