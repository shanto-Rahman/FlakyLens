@Test public void testNotifyFirst() throws Exception {
  doAnswer(successfulReplace).when(cache).replace(any(),any(),any());
  final WaitNotifyProtocol protocol=new WaitNotifyProtocol(cache);
  final String signalId="signal-id";
  final Signal signal=protocol.notify(signalId,"a",1,null);
  assertNotNull(signal);
  assertEquals(Long.valueOf(1),signal.getCounts().get("a"));
  assertTrue(cacheEntries.containsKey("signal-id"));
  final AtomicCacheEntry<String,String,Long> cacheEntry=cacheEntries.get("signal-id");
  assertEquals(1,cacheEntry.getRevision().orElse(-1L).longValue());
  assertEquals("{\"counts\":{\"a\":1},\"attributes\":{},\"releasableCount\":0}",cacheEntry.getValue());
}
