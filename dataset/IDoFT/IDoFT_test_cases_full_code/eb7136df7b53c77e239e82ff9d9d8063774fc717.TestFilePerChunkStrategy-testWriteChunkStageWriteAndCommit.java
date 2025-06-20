@Test public void testWriteChunkStageWriteAndCommit() throws Exception {
  ChunkManager chunkManager=createTestSubject();
  checkChunkFileCount(0);
  checkWriteIOStats(0,0);
  KeyValueContainer container=getKeyValueContainer();
  BlockID blockID=getBlockID();
  ChunkInfo chunkInfo=getChunkInfo();
  chunkManager.writeChunk(container,blockID,chunkInfo,getData(),new DispatcherContext.Builder().setStage(DispatcherContext.WriteChunkStage.WRITE_DATA).build());
  checkChunkFileCount(1);
  long term=0;
  long index=0;
  File chunkFile=ChunkLayOutVersion.FILE_PER_CHUNK.getChunkFile(container.getContainerData(),blockID,chunkInfo);
  File tempChunkFile=new File(chunkFile.getParent(),chunkFile.getName() + OzoneConsts.CONTAINER_CHUNK_NAME_DELIMITER + OzoneConsts.CONTAINER_TEMPORARY_CHUNK_PREFIX+ OzoneConsts.CONTAINER_CHUNK_NAME_DELIMITER+ term+ OzoneConsts.CONTAINER_CHUNK_NAME_DELIMITER+ index);
  assertTrue(tempChunkFile.exists());
  checkWriteIOStats(chunkInfo.getLen(),1);
  chunkManager.writeChunk(container,blockID,chunkInfo,getData(),new DispatcherContext.Builder().setStage(DispatcherContext.WriteChunkStage.COMMIT_DATA).build());
  checkWriteIOStats(chunkInfo.getLen(),1);
  checkChunkFileCount(1);
  assertTrue(chunkFile.exists());
  assertFalse(tempChunkFile.exists());
}
