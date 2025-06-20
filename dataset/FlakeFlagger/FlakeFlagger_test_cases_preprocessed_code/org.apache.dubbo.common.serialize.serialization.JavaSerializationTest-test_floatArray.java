@Test public void test_floatArray() throws Exception {
assertArrayEquals(data,(float[])deserialize.readObject(),0.0001F);
fail();
}