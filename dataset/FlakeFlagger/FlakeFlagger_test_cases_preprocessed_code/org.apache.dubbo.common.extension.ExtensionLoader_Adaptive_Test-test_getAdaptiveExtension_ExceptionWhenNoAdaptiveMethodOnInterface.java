@Test public void test_getAdaptiveExtension_ExceptionWhenNoAdaptiveMethodOnInterface() throws Exception {
fail();
assertThat(expected.getMessage(),allOf(containsString("Can not create adaptive extension interface org.apache.dubbo.common.extension.ext5.NoAdaptiveMethodExt"),containsString("No adaptive method on extension org.apache.dubbo.common.extension.ext5.NoAdaptiveMethodExt, refuse to create the adaptive class")));
fail();
assertThat(expected.getMessage(),allOf(containsString("Can not create adaptive extension interface org.apache.dubbo.common.extension.ext5.NoAdaptiveMethodExt"),containsString("No adaptive method on extension org.apache.dubbo.common.extension.ext5.NoAdaptiveMethodExt, refuse to create the adaptive class")));
}