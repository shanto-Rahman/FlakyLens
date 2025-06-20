@Test public void testReset() throws Exception {
assertEquals(new DefaultExtension(),draft_6455.getExtension());
assertNull(draft_6455.getProtocol());
assertEquals(extensionList,draft_6455.getKnownExtensions());
assertEquals(protocolList,draft_6455.getKnownProtocols());
}