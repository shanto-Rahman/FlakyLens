@Test public void testSendSuccess() throws Exception {
  try (final SiteToSiteClient client=getDefaultBuilder().portName("input-running").build()){
    testSend(client);
  }
 }
