@Test public void resumeNullBatch() throws Exception {
assertNull(InfinispanBatcher.getCurrentBatch());
assertSame(batch,InfinispanBatcher.getCurrentBatch());
}