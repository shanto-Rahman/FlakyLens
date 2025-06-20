@Test public void resumeBatch() throws Exception {
assertSame(batch,InfinispanBatcher.getCurrentBatch());
assertNull(InfinispanBatcher.getCurrentBatch());
}