@Test public void testSendSuccessHTTPS() throws Exception {
  try (final SiteToSiteClient client=getDefaultBuilderHTTPS().portName("input-running").build()){
    testSend(client);
  }
 }
