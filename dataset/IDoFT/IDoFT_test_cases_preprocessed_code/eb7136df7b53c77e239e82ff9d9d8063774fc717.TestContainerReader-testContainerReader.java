@Test public void testContainerReader() throws Exception {
thread.start();
thread.join();
Assert.assertEquals(2,containerSet.containerCount());
Assert.assertEquals(blockCount,keyValueContainerData.getKeyCount());
Assert.assertEquals(blockCount * blockLen,keyValueContainerData.getBytesUsed());
Assert.assertEquals(i,keyValueContainerData.getNumPendingDeletionBlocks());
}