@Test public void createBatchClose() throws Exception {
assertSame(tx,batch.getTransaction());
assertNull(InfinispanBatcher.getCurrentBatch());
}