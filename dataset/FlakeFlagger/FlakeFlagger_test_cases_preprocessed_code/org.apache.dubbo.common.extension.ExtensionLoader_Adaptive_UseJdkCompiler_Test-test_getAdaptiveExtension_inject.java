@Test public void test_getAdaptiveExtension_inject() throws Exception {
assertEquals("Ext6Impl1-echo-Ext1Impl1-echo",ext.echo(url,"ha"));
Assert.assertTrue("can not find error.",LogUtil.checkNoError());
assertEquals("Ext6Impl1-echo-Ext1Impl2-echo",ext.echo(url,"ha"));
}