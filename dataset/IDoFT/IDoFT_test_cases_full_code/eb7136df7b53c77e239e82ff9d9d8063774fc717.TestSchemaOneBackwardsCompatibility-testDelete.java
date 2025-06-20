/** 
 * Tests reading blocks marked for deletion from a container written in schema version 1. Because the block deleting service both reads for deleted blocks and deletes them, this test will modify its copy of the database.
 */
@Test public void testDelete() throws Exception {
  final long numBlocksToDelete=TestDB.NUM_PENDING_DELETION_BLOCKS;
  String datanodeUuid=UUID.randomUUID().toString();
  ContainerSet containerSet=makeContainerSet();
  VolumeSet volumeSet=new MutableVolumeSet(datanodeUuid,conf,null,StorageVolume.VolumeType.DATA_VOLUME,null);
  ContainerMetrics metrics=ContainerMetrics.create(conf);
  KeyValueHandler keyValueHandler=new KeyValueHandler(conf,datanodeUuid,containerSet,volumeSet,metrics,c -> {
  }
);
  long initialTotalSpace=newKvData().getBytesUsed();
  long blockSpace=initialTotalSpace / TestDB.KEY_COUNT;
  runBlockDeletingService(keyValueHandler);
  GenericTestUtils.waitFor(() -> {
    try {
      return (newKvData().getBytesUsed() != initialTotalSpace);
    }
 catch (    IOException ex) {
    }
    return false;
  }
,100,3000);
  long currentTotalSpace=newKvData().getBytesUsed();
  long numberOfBlocksDeleted=(initialTotalSpace - currentTotalSpace) / blockSpace;
  final long expectedDeletingBlocks=TestDB.NUM_PENDING_DELETION_BLOCKS - numBlocksToDelete;
  final long expectedDeletedBlocks=TestDB.NUM_DELETED_BLOCKS + numBlocksToDelete;
  final long expectedRegularBlocks=TestDB.KEY_COUNT - numBlocksToDelete;
  try (ReferenceCountedDB refCountedDB=BlockUtils.getDB(newKvData(),conf)){
    assertEquals(expectedDeletingBlocks,countDeletingBlocks(refCountedDB));
    assertEquals(expectedDeletedBlocks,TestDB.NUM_DELETED_BLOCKS + numberOfBlocksDeleted);
    assertEquals(expectedRegularBlocks,countUnprefixedBlocks(refCountedDB));
    Table<String,Long> metadataTable=refCountedDB.getStore().getMetadataTable();
    assertEquals(expectedRegularBlocks + expectedDeletingBlocks,(long)metadataTable.get(OzoneConsts.BLOCK_COUNT));
  }
 }
