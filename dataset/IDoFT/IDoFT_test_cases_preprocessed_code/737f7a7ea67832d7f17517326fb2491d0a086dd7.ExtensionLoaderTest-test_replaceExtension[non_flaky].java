@Test public void test_replaceExtension() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("No such extension org.apache.dubbo.common.extension.ext8_add.AddExt1 by name Manual"));
assertThat(ext,instanceOf(AddExt1Impl1.class));
assertEquals("impl1",getExtensionLoader(AddExt1.class).getExtensionName(AddExt1Impl1.class));
assertThat(ext,instanceOf(AddExt1_ManualAdd2.class));
assertEquals("impl1",getExtensionLoader(AddExt1.class).getExtensionName(AddExt1_ManualAdd2.class));
}