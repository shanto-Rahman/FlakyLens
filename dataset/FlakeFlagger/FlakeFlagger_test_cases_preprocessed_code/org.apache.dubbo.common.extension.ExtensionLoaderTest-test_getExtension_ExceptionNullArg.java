@Test public void test_getExtension_ExceptionNullArg() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Extension name == null"));
}