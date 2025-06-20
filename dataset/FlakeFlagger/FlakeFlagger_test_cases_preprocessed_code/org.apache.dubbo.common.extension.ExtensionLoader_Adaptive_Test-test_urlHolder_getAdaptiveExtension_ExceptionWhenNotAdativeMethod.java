@Test public void test_urlHolder_getAdaptiveExtension_ExceptionWhenNotAdativeMethod() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("method "));
assertThat(expected.getMessage(),containsString("of interface org.apache.dubbo.common.extension.ext2.Ext2 is not adaptive method!"));
}