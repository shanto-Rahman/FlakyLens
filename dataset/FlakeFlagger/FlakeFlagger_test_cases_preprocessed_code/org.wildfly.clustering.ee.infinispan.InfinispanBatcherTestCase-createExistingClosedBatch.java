@Test public void createExistingClosedBatch() throws Exception {
assertSame(tx,batch.getTransaction());
assertSame(batch,InfinispanBatcher.getCurrentBatch());
assertNull(InfinispanBatcher.getCurrentBatch());
}