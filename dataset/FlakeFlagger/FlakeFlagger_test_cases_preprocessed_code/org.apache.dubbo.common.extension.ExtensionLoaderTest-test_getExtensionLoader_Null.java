@Test public void test_getExtensionLoader_Null() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Extension type == null"));
}