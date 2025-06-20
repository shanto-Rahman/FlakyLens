@Test public void test_intArray() throws Exception {
assertArrayEquals(data,(int[])deserialize.readObject());
fail();
}