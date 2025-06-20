@Test public void test_AddExtension() throws Exception {
  try {
    getExtensionLoader(AddExt1.class).getExtension("Manual1");
    fail();
  }
 catch (  IllegalStateException expected) {
    assertThat(expected.getMessage(),containsString("No such extension org.apache.dubbo.common.extension.ext8_add.AddExt1 by name Manual"));
  }
  getExtensionLoader(AddExt1.class).addExtension("Manual1",AddExt1_ManualAdd1.class);
  AddExt1 ext=getExtensionLoader(AddExt1.class).getExtension("Manual1");
  assertThat(ext,instanceOf(AddExt1_ManualAdd1.class));
  assertEquals("Manual1",getExtensionLoader(AddExt1.class).getExtensionName(AddExt1_ManualAdd1.class));
  ExtensionLoader.resetExtensionLoader(AddExt1.class);
}
