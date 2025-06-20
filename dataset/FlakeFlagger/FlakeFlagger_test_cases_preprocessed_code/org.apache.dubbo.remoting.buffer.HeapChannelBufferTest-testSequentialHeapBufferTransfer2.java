@Test public void testSequentialHeapBufferTransfer2(){
assertEquals(0,buffer.readerIndex());
assertEquals(i,buffer.writerIndex());
assertEquals(readerIndex + BLOCK_SIZE,value.writerIndex());
assertEquals(value.writerIndex(),value.readerIndex());
assertEquals(i,buffer.readerIndex());
assertEquals(CAPACITY,buffer.writerIndex());
assertEquals(expectedValue.getByte(j),value.getByte(j));
assertEquals(valueOffset,value.readerIndex());
assertEquals(valueOffset + BLOCK_SIZE,value.writerIndex());
}