@Test public void testCopy(){
assertEquals(0,copy.readerIndex());
assertEquals(buffer.readableBytes(),copy.writerIndex());
assertEquals(buffer.readableBytes(),copy.capacity());
assertEquals(buffer.getByte(i + readerIndex),copy.getByte(i));
assertTrue(buffer.getByte(readerIndex) != copy.getByte(0));
assertTrue(buffer.getByte(readerIndex + 1) != copy.getByte(1));
}