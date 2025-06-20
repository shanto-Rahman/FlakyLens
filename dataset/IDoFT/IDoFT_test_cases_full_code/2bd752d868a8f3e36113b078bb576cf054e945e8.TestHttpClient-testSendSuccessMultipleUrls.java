@Test public void testSendSuccessMultipleUrls() throws Exception {
  final Set<String> urls=new LinkedHashSet<>();
  urls.add("http://localhost:9999");
  urls.add("http://localhost:" + httpConnector.getLocalPort() + "/nifi");
  try (final SiteToSiteClient client=getDefaultBuilder().urls(urls).portName("input-running").build()){
    testSend(client);
  }
 }
