@Test public void test_doubleArray() throws Exception {
assertArrayEquals(data,(double[])deserialize.readObject(),0.0001);
fail();
}