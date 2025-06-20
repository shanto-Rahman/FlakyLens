@Test public void testDeletePartialChunkWithOffsetUnsupportedRequest(){
  ChunkManager chunkManager=createTestSubject();
  try {
    KeyValueContainer container=getKeyValueContainer();
    BlockID blockID=getBlockID();
    chunkManager.writeChunk(container,blockID,getChunkInfo(),getData(),getDispatcherContext());
    ChunkInfo chunkInfo=new ChunkInfo(String.format("%d.data.%d",blockID.getLocalID(),0),123,getChunkInfo().getLen());
    chunkManager.deleteChunk(container,blockID,chunkInfo);
    fail("testDeleteChunkUnsupportedRequest");
  }
 catch (  StorageContainerException ex) {
    assertEquals(ContainerProtos.Result.UNSUPPORTED_REQUEST,ex.getResult());
  }
}
