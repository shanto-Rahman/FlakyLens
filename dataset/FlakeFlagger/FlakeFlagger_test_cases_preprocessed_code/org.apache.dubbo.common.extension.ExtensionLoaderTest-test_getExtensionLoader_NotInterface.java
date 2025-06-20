@Test public void test_getExtensionLoader_NotInterface() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Extension type(class org.apache.dubbo.common.extension.ExtensionLoaderTest) is not interface"));
}