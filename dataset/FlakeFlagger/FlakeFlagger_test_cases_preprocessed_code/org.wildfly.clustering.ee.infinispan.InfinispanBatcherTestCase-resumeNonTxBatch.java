@Test public void resumeNonTxBatch() throws Exception {
assertSame(batch,InfinispanBatcher.getCurrentBatch());
assertSame(existingBatch,InfinispanBatcher.getCurrentBatch());
}