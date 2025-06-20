@Test public void dummyManagerDoesNotWriteToFile() throws Exception {
  ChunkManager subject=createTestSubject();
  DispatcherContext ctx=new DispatcherContext.Builder().setStage(DispatcherContext.WriteChunkStage.WRITE_DATA).build();
  subject.writeChunk(getKeyValueContainer(),getBlockID(),getChunkInfo(),getData(),ctx);
  checkChunkFileCount(0);
}
