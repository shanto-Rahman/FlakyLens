@SuppressWarnings("resource") @Test public void createOverlappingBatchDiscard() throws Exception {
assertSame(tx,batch.getTransaction());
assertNull(InfinispanBatcher.getCurrentBatch());
}