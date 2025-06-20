@Test public void testSequentialByteArrayTransfer1(){
assertEquals(0,buffer.readerIndex());
assertEquals(i,buffer.writerIndex());
assertEquals(i,buffer.readerIndex());
assertEquals(CAPACITY,buffer.writerIndex());
assertEquals(expectedValue[j],value[j]);
}