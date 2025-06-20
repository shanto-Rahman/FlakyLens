@Test public void test_StringArray_withType() throws Exception {
assertArrayEquals(data,deserialize.readObject(String[].class));
fail();
}