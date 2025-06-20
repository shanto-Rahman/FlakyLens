@Test public void testGetTransport3(){
assertEquals(NettyTransporter.class,ExtensionLoader.getExtensionLoader(Transporter.class).getExtension(name).getClass());
}