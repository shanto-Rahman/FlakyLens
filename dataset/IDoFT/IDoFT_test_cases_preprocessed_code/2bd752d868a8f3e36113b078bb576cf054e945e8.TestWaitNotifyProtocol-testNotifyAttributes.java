@Test public void testNotifyAttributes() throws Exception {
assertEquals(1L,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("{\"counts\":{\"a\":1},\"attributes\":{\"p1\":\"a1\",\"p2\":\"a1\"},\"releasableCount\":0}",cacheEntry.getValue());
assertEquals(2L,cacheEntry.getRevision().orElse(-1L).longValue());
assertEquals("Updated attributes should be merged correctly","{\"counts\":{\"a\":2},\"attributes\":{\"p1\":\"a1\",\"p2\":\"a2\",\"p3\":\"a2\"},\"releasableCount\":0}",cacheEntry.getValue());
}