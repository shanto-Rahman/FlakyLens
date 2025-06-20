@Test public void test_replaceExtension_Adaptive_ExceptionWhenNotExistedExtension() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Adaptive Extension not existed(Extension interface org.apache.dubbo.common.extension.ext8_add.AddExt4)"));
}