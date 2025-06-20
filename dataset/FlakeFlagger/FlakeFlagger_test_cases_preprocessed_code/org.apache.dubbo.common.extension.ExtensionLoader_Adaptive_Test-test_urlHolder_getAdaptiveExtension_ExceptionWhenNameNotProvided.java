@Test public void test_urlHolder_getAdaptiveExtension_ExceptionWhenNameNotProvided() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Fail to get extension("));
fail();
assertThat(expected.getMessage(),containsString("Fail to get extension(org.apache.dubbo.common.extension.ext2.Ext2) name from url"));
}