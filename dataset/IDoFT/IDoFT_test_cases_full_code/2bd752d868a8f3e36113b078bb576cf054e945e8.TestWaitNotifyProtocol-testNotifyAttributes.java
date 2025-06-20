@Test public void testNotifyAttributes() throws Exception {
  doAnswer(successfulReplace).when(cache).replace(any(),any(),any());
  final WaitNotifyProtocol protocol=new WaitNotifyProtocol(cache);
  final String signalId="signal-id";
  final Map<String,String> attributeA1=new HashMap<>();
  attributeA1.put("p1","a1");
  attributeA1.put("p2","a1");
  protocol.notify(signalId,"a",1,attributeA1);
  AtomicCacheEntry<String,String,Long> cacheEntry=cacheEntries.get("signal-id");
  assertEquals(1L,cacheEntry.getRevision().orElse(-1L).longValue());
  assertEquals("{\"counts\":{\"a\":1},\"attributes\":{\"p1\":\"a1\",\"p2\":\"a1\"},\"releasableCount\":0}",cacheEntry.getValue());
  final Map<String,String> attributeA2=new HashMap<>();
  attributeA2.put("p2","a2");
  attributeA2.put("p3","a2");
  protocol.notify(signalId,"a",1,attributeA2);
  cacheEntry=cacheEntries.get("signal-id");
  assertEquals(2L,cacheEntry.getRevision().orElse(-1L).longValue());
  assertEquals("Updated attributes should be merged correctly","{\"counts\":{\"a\":2},\"attributes\":{\"p1\":\"a1\",\"p2\":\"a2\",\"p3\":\"a2\"},\"releasableCount\":0}",cacheEntry.getValue());
}
