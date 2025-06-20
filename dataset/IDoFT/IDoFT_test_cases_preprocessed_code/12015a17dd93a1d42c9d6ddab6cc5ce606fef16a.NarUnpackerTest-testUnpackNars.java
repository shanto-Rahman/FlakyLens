@Test public void testUnpackNars(){
assertEquals("./target/NarUnpacker/lib/",properties.getProperty("nifi.nar.library.directory"));
assertEquals("./target/NarUnpacker/lib2/",properties.getProperty("nifi.nar.library.directory.alt"));
assertEquals(2,extensionMapping.getAllExtensionNames().size());
assertTrue(extensionMapping.getAllExtensionNames().keySet().contains("org.apache.nifi.processors.dummy.one"));
assertTrue(extensionMapping.getAllExtensionNames().keySet().contains("org.apache.nifi.processors.dummy.two"));
assertEquals(expectedNars.size(),extensionFiles.length);
Assert.assertTrue(expectedNars.contains(extensionFile.getName()));
}