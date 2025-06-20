/** 
 * Test partial within a single chunk.
 */
@Test public void testPartialRead() throws Exception {
  final int datalen=1024;
  final int start=datalen / 4;
  final int length=datalen / 2;
  KeyValueContainer container=getKeyValueContainer();
  BlockID blockID=getBlockID();
  ChunkInfo info=getChunk(blockID.getLocalID(),0,0,datalen);
  ChunkBuffer data=ContainerTestHelper.getData(datalen);
  setDataChecksum(info,data);
  DispatcherContext ctx=getDispatcherContext();
  ChunkManager subject=createTestSubject();
  subject.writeChunk(container,blockID,info,data,ctx);
  ChunkBuffer readData=subject.readChunk(container,blockID,info,ctx);
  assertEquals(data.rewind().toByteString(),readData.rewind().toByteString());
  ChunkInfo info2=getChunk(blockID.getLocalID(),0,start,length);
  ChunkBuffer readData2=subject.readChunk(container,blockID,info2,ctx);
  assertEquals(length,info2.getLen());
  assertEquals(data.rewind().toByteString().substring(start,start + length),readData2.rewind().toByteString());
}
