@SuppressWarnings("resource") @Test public void createOverlappingBatchClose() throws Exception {
assertSame(tx,batch.getTransaction());
assertNull(InfinispanBatcher.getCurrentBatch());
}