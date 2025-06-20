@Test public void test_AddExtension_ExceptionWhenExistedExtension() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Extension name impl1 already existed(Extension interface org.apache.dubbo.common.extension.ext8_add.AddExt1)!"));
}