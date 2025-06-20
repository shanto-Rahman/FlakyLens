@Test public void testGetTransport1(){
assertEquals(MinaTransporter.class,ExtensionLoader.getExtensionLoader(Transporter.class).getExtension(name).getClass());
}