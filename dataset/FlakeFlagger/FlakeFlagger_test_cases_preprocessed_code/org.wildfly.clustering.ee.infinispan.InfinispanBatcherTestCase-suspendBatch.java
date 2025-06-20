@Test public void suspendBatch() throws Exception {
assertSame(batch,result);
assertNull(InfinispanBatcher.getCurrentBatch());
}