@Test public void dummyManagerReadsAnyChunk() throws Exception {
  ChunkManager dummy=createTestSubject();
  ChunkBuffer dataRead=dummy.readChunk(getKeyValueContainer(),getBlockID(),getChunkInfo(),getDispatcherContext());
  assertNotNull(dataRead);
}
