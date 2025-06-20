@Test public void testSequentialCopiedBufferTransfer1(){
assertEquals(0,buffer.readerIndex());
assertEquals(i,buffer.writerIndex());
assertEquals(i,buffer.readerIndex());
assertEquals(CAPACITY,buffer.writerIndex());
assertEquals(wrappedBuffer(expectedValue),actualValue);
assertFalse(buffer.getByte(i) == actualValue.getByte(0));
}