@Test public void test_boolArray() throws Exception {
assertTrue(Arrays.equals(data,(boolean[])deserialize.readObject()));
fail();
}