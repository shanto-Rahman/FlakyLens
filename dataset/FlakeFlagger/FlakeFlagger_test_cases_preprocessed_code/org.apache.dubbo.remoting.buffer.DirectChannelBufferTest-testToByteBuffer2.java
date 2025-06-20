@Test public void testToByteBuffer2(){
assertEquals(ByteBuffer.wrap(value,i,BLOCK_SIZE),buffer.toByteBuffer(i,BLOCK_SIZE));
}