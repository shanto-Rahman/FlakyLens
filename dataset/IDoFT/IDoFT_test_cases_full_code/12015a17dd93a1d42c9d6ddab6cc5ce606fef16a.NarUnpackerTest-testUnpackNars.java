@Test public void testUnpackNars(){
  NiFiProperties properties=loadSpecifiedProperties("/NarUnpacker/conf/nifi.properties",Collections.EMPTY_MAP);
  assertEquals("./target/NarUnpacker/lib/",properties.getProperty("nifi.nar.library.directory"));
  assertEquals("./target/NarUnpacker/lib2/",properties.getProperty("nifi.nar.library.directory.alt"));
  final ExtensionMapping extensionMapping=NarUnpacker.unpackNars(properties,SystemBundle.create(properties));
  assertEquals(2,extensionMapping.getAllExtensionNames().size());
  assertTrue(extensionMapping.getAllExtensionNames().keySet().contains("org.apache.nifi.processors.dummy.one"));
  assertTrue(extensionMapping.getAllExtensionNames().keySet().contains("org.apache.nifi.processors.dummy.two"));
  final File extensionsWorkingDir=properties.getExtensionsWorkingDirectory();
  File[] extensionFiles=extensionsWorkingDir.listFiles();
  Set<String> expectedNars=new HashSet<>();
  expectedNars.add("dummy-one.nar-unpacked");
  expectedNars.add("dummy-two.nar-unpacked");
  expectedNars.add("nifi-jetty-bundle.nar-unpacked");
  assertEquals(expectedNars.size(),extensionFiles.length);
  for (  File extensionFile : extensionFiles) {
    Assert.assertTrue(expectedNars.contains(extensionFile.getName()));
  }
}
