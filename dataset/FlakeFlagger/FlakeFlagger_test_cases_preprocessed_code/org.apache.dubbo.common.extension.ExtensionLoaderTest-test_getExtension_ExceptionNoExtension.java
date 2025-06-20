@Test public void test_getExtension_ExceptionNoExtension() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("No such extension org.apache.dubbo.common.extension.ext1.SimpleExt by name XXX"));
}