@Test public void resumeBatchExisting() throws Exception {
assertSame(batch,InfinispanBatcher.getCurrentBatch());
assertSame(existingBatch,InfinispanBatcher.getCurrentBatch());
}