/** 
 * Tests reading the chunk info saved from a block that was deleted from a database in schema version one. Blocks deleted from schema version one before the upgrade will have the block ID saved as their value. Trying to retrieve this value as a  {@link ChunkInfoList} should fail. Blocksdeleted from schema version one after the upgrade should have their {@link ChunkInfoList} saved as the corresponding value in the deletedblocks table. Reading these values should succeed.
 * @throws Exception
 */
@Test public void testReadDeletedBlockChunkInfo() throws Exception {
  String datanodeUuid=UUID.randomUUID().toString();
  ContainerSet containerSet=makeContainerSet();
  VolumeSet volumeSet=new MutableVolumeSet(datanodeUuid,conf,null,StorageVolume.VolumeType.DATA_VOLUME,null);
  ContainerMetrics metrics=ContainerMetrics.create(conf);
  KeyValueHandler keyValueHandler=new KeyValueHandler(conf,datanodeUuid,containerSet,volumeSet,metrics,c -> {
  }
);
  try (ReferenceCountedDB refCountedDB=BlockUtils.getDB(newKvData(),conf)){
    List<? extends Table.KeyValue<String,ChunkInfoList>> deletedBlocks=refCountedDB.getStore().getDeletedBlocksTable().getRangeKVs(null,100);
    Set<String> preUpgradeBlocks=new HashSet<>();
    for (    Table.KeyValue<String,ChunkInfoList> chunkListKV : deletedBlocks) {
      preUpgradeBlocks.add(chunkListKV.getKey());
      try {
        chunkListKV.getValue();
        Assert.fail("No exception thrown when trying to retrieve old " + "deleted blocks values as chunk lists.");
      }
 catch (      IOException ex) {
      }
    }
    Assert.assertEquals(TestDB.NUM_DELETED_BLOCKS,preUpgradeBlocks.size());
    long initialTotalSpace=newKvData().getBytesUsed();
    long blockSpace=initialTotalSpace / TestDB.KEY_COUNT;
    runBlockDeletingService(keyValueHandler);
    GenericTestUtils.waitFor(() -> {
      try {
        return (newKvData().getBytesUsed() != initialTotalSpace);
      }
 catch (      IOException ex) {
      }
      return false;
    }
,100,3000);
    long currentTotalSpace=newKvData().getBytesUsed();
    long numberOfBlocksDeleted=(initialTotalSpace - currentTotalSpace) / blockSpace;
    Assert.assertEquals(TestDB.NUM_PENDING_DELETION_BLOCKS,numberOfBlocksDeleted);
  }
 }
