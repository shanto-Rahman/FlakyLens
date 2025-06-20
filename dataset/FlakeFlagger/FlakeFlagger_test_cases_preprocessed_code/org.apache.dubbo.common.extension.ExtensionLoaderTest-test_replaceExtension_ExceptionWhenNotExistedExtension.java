@Test public void test_replaceExtension_ExceptionWhenNotExistedExtension() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Extension name NotExistedExtension not existed(Extension interface org.apache.dubbo.common.extension.ext8_add.AddExt1)"));
}