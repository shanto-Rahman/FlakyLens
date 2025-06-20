@Test public void testAcceptProvidedExtensionAsClient() throws Exception {
assertTrue(defaultExtension.acceptProvidedExtensionAsClient("Test"));
assertTrue(defaultExtension.acceptProvidedExtensionAsClient(""));
assertTrue(defaultExtension.acceptProvidedExtensionAsClient("Test, ASDC, as, ad"));
assertTrue(defaultExtension.acceptProvidedExtensionAsClient("ASDC, as,ad"));
assertTrue(defaultExtension.acceptProvidedExtensionAsClient("permessage-deflate"));
}