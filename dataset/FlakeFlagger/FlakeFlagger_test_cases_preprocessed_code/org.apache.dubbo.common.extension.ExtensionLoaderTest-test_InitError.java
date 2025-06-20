@Test public void test_InitError() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("Failed to load extension class(interface: interface org.apache.dubbo.common.extension.ext7.InitErrorExt"));
assertThat(expected.getCause(),instanceOf(ExceptionInInitializerError.class));
}