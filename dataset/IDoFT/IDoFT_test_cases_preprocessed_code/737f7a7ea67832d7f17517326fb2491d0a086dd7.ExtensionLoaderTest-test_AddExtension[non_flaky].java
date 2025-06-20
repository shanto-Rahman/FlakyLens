@Test public void test_AddExtension() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("No such extension org.apache.dubbo.common.extension.ext8_add.AddExt1 by name Manual"));
assertThat(ext,instanceOf(AddExt1_ManualAdd1.class));
assertEquals("Manual1",getExtensionLoader(AddExt1.class).getExtensionName(AddExt1_ManualAdd1.class));
}