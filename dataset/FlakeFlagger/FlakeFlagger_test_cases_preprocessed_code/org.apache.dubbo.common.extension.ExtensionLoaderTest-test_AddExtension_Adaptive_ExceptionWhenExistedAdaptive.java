@Test public void test_AddExtension_Adaptive_ExceptionWhenExistedAdaptive() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Adaptive Extension already existed(Extension interface org.apache.dubbo.common.extension.ext8_add.AddExt1)!"));
}