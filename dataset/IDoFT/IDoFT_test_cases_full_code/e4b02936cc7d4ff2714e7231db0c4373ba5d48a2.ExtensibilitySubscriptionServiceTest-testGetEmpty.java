@Test public void testGetEmpty() throws InterruptedException {
  ServiceDocumentQueryResult result=sender.sendAndWait(Operation.createGet(host,ExtensibilitySubscriptionService.FACTORY_LINK),ServiceDocumentQueryResult.class);
  assertNotNull(result);
  assertNotNull(result.documentCount);
  assertEquals(0L,(long)result.documentCount);
}
