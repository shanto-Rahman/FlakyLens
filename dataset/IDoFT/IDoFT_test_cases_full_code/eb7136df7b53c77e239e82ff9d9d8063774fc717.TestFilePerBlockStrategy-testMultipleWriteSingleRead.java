/** 
 * This test writes data as many small writes and tries to read back the data in a single large read.
 */
@Test public void testMultipleWriteSingleRead() throws Exception {
  final int datalen=1024;
  final int chunkCount=1024;
  KeyValueContainer container=getKeyValueContainer();
  BlockID blockID=getBlockID();
  MessageDigest oldSha=MessageDigest.getInstance(OzoneConsts.FILE_HASH);
  ChunkManager subject=createTestSubject();
  for (int x=0; x < chunkCount; x++) {
    long offset=x * datalen;
    ChunkInfo info=getChunk(blockID.getLocalID(),0,offset,datalen);
    ChunkBuffer data=ContainerTestHelper.getData(datalen);
    oldSha.update(data.toByteString().asReadOnlyByteBuffer());
    data.rewind();
    setDataChecksum(info,data);
    subject.writeChunk(container,blockID,info,data,getDispatcherContext());
  }
  ChunkInfo largeChunk=getChunk(blockID.getLocalID(),0,0,datalen * chunkCount);
  ChunkBuffer chunk=subject.readChunk(container,blockID,largeChunk,getDispatcherContext());
  ByteBuffer newdata=chunk.toByteString().asReadOnlyByteBuffer();
  MessageDigest newSha=MessageDigest.getInstance(OzoneConsts.FILE_HASH);
  newSha.update(newdata);
  assertEquals(Hex.encodeHexString(oldSha.digest()),Hex.encodeHexString(newSha.digest()));
}
