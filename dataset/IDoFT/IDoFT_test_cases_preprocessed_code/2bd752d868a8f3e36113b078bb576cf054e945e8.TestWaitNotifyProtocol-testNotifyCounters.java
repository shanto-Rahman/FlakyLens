@Test public void testNotifyCounters() throws Exception {
assertEquals(2,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("{\"counts\":{\"a\":2},\"attributes\":{},\"releasableCount\":0}",cacheEntry.getValue());
assertEquals(3,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("{\"counts\":{\"a\":12},\"attributes\":{},\"releasableCount\":0}",cacheEntry.getValue());
assertEquals(5,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("{\"counts\":{\"a\":12,\"b\":2,\"c\":3},\"attributes\":{},\"releasableCount\":0}",cacheEntry.getValue());
assertEquals(6,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("{\"counts\":{\"a\":22,\"b\":27,\"c\":3},\"attributes\":{},\"releasableCount\":0}",cacheEntry.getValue());
assertEquals(7,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("{\"counts\":{\"a\":22,\"b\":0,\"c\":3},\"attributes\":{},\"releasableCount\":0}",cacheEntry.getValue());
}