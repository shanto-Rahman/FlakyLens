/** 
 * Tests that "new datanode" can delete chunks written to "old datanode" by "new client" (ie. where chunk file accidentally created with {@code size = chunk offset + chunk length}, instead of only chunk length).
 */
@Test public void deletesChunkFileWithLengthIncludingOffset() throws Exception {
  ChunkManager chunkManager=createTestSubject();
  KeyValueContainer container=getKeyValueContainer();
  BlockID blockID=getBlockID();
  ChunkInfo chunkInfo=getChunkInfo();
  long offset=1024;
  ChunkInfo oldDatanodeChunkInfo=new ChunkInfo(chunkInfo.getChunkName(),offset,chunkInfo.getLen());
  File file=ChunkLayOutVersion.FILE_PER_CHUNK.getChunkFile(container.getContainerData(),blockID,chunkInfo);
  ChunkUtils.writeData(file,ChunkBuffer.wrap(getData()),offset,chunkInfo.getLen(),null,true);
  checkChunkFileCount(1);
  assertTrue(file.exists());
  assertEquals(offset + chunkInfo.getLen(),file.length());
  chunkManager.deleteChunk(container,blockID,oldDatanodeChunkInfo);
  checkChunkFileCount(0);
  assertFalse(file.exists());
}
