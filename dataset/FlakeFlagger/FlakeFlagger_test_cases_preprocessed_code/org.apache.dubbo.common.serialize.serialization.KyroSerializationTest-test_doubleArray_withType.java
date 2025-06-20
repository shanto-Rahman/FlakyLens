@Test public void test_doubleArray_withType() throws Exception {
assertArrayEquals(data,(double[])deserialize.readObject(double[].class),0.0001);
fail();
}