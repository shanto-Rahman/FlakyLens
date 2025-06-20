@Test public void createBatchDiscard() throws Exception {
assertSame(tx,batch.getTransaction());
assertNull(InfinispanBatcher.getCurrentBatch());
}