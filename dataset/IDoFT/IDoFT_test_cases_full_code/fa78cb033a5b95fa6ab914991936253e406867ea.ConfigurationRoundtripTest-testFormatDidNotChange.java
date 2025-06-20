@Test @LocalData public void testFormatDidNotChange() throws Exception {
  String previousConfig=getConfig();
  assertThat(previousConfig).isNotNull();
  assertThat(previousConfig).isNotEmpty();
  LibraryConfiguration lib=new LibraryConfiguration("foo",new HttpRetriever("http://example.com/",credentials.getId(),true));
  globalLibraries.getLibraries().clear();
  globalLibraries.getLibraries().add(lib);
  j.configRoundtrip();
  String currentConfig=getConfig();
  String message="Your config format changed. If it is intentional and necessary:\n";
  message+=" - update this test with new test data that reflects your new data format\n";
  message+=" - create test to make sure that new code can cope with old data format" + " (testConfigurationRoundtripXXX)";
  message+="\n\n";
  message+="Old config:\n" + previousConfig;
  message+="\n\n";
  message+="New config:\n" + currentConfig;
  message+="\n\n";
  assertThat(previousConfig).withFailMessage(message).isXmlEqualTo(currentConfig);
}
