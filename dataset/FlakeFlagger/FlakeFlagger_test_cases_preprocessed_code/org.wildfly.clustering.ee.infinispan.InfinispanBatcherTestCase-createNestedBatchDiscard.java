@Test public void createNestedBatchDiscard() throws Exception {
assertSame(tx,outerBatch.getTransaction());
assertNull(InfinispanBatcher.getCurrentBatch());
}