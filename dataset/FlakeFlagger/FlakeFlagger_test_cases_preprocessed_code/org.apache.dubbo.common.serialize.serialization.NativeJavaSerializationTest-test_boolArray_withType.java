@Test public void test_boolArray_withType() throws Exception {
assertTrue(Arrays.equals(data,(boolean[])deserialize.readObject(boolean[].class)));
fail();
}