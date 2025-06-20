@Test public void testSequentialHeapBufferTransfer1(){
assertEquals(0,buffer.readerIndex());
assertEquals(i,buffer.writerIndex());
assertEquals(0,value.readerIndex());
assertEquals(valueContent.length,value.writerIndex());
assertEquals(i,buffer.readerIndex());
assertEquals(CAPACITY,buffer.writerIndex());
assertEquals(expectedValue.getByte(j),value.getByte(j));
assertEquals(0,value.readerIndex());
assertEquals(valueContent.length,value.writerIndex());
}