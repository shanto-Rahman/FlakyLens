@Test public void testRandomHeapBufferTransfer1(){
assertEquals(BLOCK_SIZE,value.readerIndex());
assertEquals(BLOCK_SIZE,value.writerIndex());
assertEquals(0,value.readerIndex());
assertEquals(BLOCK_SIZE,value.writerIndex());
assertEquals(expectedValue.getByte(j),value.getByte(j));
}