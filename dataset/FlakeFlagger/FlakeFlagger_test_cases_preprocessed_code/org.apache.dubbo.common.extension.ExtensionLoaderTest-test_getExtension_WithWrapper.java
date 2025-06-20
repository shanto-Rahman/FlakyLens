@Test public void test_getExtension_WithWrapper() throws Exception {
assertThat(impl1,anyOf(instanceOf(Ext5Wrapper1.class),instanceOf(Ext5Wrapper2.class)));
assertThat(impl2,anyOf(instanceOf(Ext5Wrapper1.class),instanceOf(Ext5Wrapper2.class)));
assertEquals("Ext5Impl1-echo",impl1.echo(url,"ha"));
assertEquals(echoCount1 + 1,Ext5Wrapper1.echoCount.get());
assertEquals(echoCount2 + 1,Ext5Wrapper2.echoCount.get());
}