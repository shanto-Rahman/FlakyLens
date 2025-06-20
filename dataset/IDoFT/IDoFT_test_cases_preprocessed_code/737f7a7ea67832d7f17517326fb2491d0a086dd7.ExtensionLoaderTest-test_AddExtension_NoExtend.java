@Test public void test_AddExtension_NoExtend() throws Exception {
assertThat(ext,instanceOf(Ext9Empty.class));
assertEquals("ext9",ExtensionLoader.getExtensionLoader(Ext9Empty.class).getExtensionName(Ext9EmptyImpl.class));
}