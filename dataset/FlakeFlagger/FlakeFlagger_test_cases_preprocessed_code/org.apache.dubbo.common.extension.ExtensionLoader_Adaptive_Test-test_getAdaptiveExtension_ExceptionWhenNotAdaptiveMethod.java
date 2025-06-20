@Test public void test_getAdaptiveExtension_ExceptionWhenNotAdaptiveMethod() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("method "));
assertThat(expected.getMessage(),containsString("of interface org.apache.dubbo.common.extension.ext1.SimpleExt is not adaptive method!"));
}