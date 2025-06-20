@Test public void test_getAdaptiveExtension_protocolKey() throws Exception {
assertEquals("Ext3Impl1-echo",echo);
assertEquals("Ext3Impl3-echo",echo);
assertEquals("Ext3Impl2-echo",echo);
assertEquals("Ext3Impl1-yell",yell);
assertEquals("Ext3Impl2-yell",yell);
assertEquals("Ext3Impl3-yell",yell);
}