@Test public void testContainerReader() throws Exception {
  ContainerReader containerReader=new ContainerReader(volumeSet,hddsVolume,containerSet,conf);
  Thread thread=new Thread(containerReader);
  thread.start();
  thread.join();
  Assert.assertEquals(2,containerSet.containerCount());
  for (int i=0; i < 2; i++) {
    Container keyValueContainer=containerSet.getContainer(i);
    KeyValueContainerData keyValueContainerData=(KeyValueContainerData)keyValueContainer.getContainerData();
    Assert.assertEquals(blockCount,keyValueContainerData.getKeyCount());
    Assert.assertEquals(blockCount * blockLen,keyValueContainerData.getBytesUsed());
    Assert.assertEquals(i,keyValueContainerData.getNumPendingDeletionBlocks());
  }
}
