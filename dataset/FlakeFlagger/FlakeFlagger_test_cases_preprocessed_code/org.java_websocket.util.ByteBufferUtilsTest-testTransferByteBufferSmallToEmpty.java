@Test public void testTransferByteBufferSmallToEmpty(){
ByteBuffer small=ByteBuffer.wrap(smallArray);//RW
assertArrayEquals("Small bytebuffer should not change",smallArray,small.array());//RW
assertEquals("Capacity of the empty bytebuffer should still be 0",0,empty.capacity());
}