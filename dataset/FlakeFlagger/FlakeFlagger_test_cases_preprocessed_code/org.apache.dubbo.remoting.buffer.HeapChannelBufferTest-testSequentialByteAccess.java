@Test public void testSequentialByteAccess(){
assertEquals(i,buffer.writerIndex());
assertTrue(buffer.writable());
assertEquals(0,buffer.readerIndex());
assertEquals(buffer.capacity(),buffer.writerIndex());
assertFalse(buffer.writable());
assertEquals(i,buffer.readerIndex());
assertTrue(buffer.readable());
assertEquals(value,buffer.readByte());
assertEquals(buffer.capacity(),buffer.readerIndex());
assertEquals(buffer.capacity(),buffer.writerIndex());
assertFalse(buffer.readable());
assertFalse(buffer.writable());
}