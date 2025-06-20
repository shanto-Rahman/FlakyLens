@Test public void test_getExtension_ExceptionNoExtension_WrapperNotAffactName() throws Exception {
fail();
assertThat(expected.getMessage(),containsString("No such extension org.apache.dubbo.common.extension.ext6_wrap.WrappedExt by name XXX"));
}