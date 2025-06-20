@Test public void testNotifyFirst() throws Exception {
assertNotNull(signal);
assertEquals(Long.valueOf(1),signal.getCounts().get("a"));
assertTrue(cacheEntries.containsKey("signal-id"));
assertEquals(1,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("{\"counts\":{\"a\":1},\"attributes\":{},\"releasableCount\":0}",cacheEntry.getValue());
}