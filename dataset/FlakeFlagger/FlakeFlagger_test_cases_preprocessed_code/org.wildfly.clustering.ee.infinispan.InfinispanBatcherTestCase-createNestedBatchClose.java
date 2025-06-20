@Test public void createNestedBatchClose() throws Exception {
assertSame(tx,outerBatch.getTransaction());
assertNull(InfinispanBatcher.getCurrentBatch());
}