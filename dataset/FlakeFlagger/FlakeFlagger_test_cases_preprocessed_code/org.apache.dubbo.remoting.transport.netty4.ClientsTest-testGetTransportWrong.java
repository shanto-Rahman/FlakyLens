@Test(expected=IllegalStateException.class) public void testGetTransportWrong(){
assertNull(ExtensionLoader.getExtensionLoader(Transporter.class).getExtension(name).getClass());
}