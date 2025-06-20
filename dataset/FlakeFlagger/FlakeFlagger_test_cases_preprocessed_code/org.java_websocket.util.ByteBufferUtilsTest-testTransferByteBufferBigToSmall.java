@Test public void testTransferByteBufferBigToSmall(){
ByteBuffer small=ByteBuffer.wrap(smallArray);//RW
ByteBuffer big=ByteBuffer.wrap(bigArray);//RW
assertArrayEquals("Big bytebuffer should not change",bigArray,big.array());//RW
assertEquals("Small bytebuffer not same to source 0",bigArray[0],small.get(0));//RW
assertEquals("Small bytebuffer not same to source 1",bigArray[1],small.get(1));//RW
assertEquals("Small bytebuffer not same to source 2",bigArray[2],small.get(2));//RW
assertEquals("Small bytebuffer not same to source 3",bigArray[3],small.get(3));//RW
assertEquals("Small bytebuffer not same to source 4",bigArray[4],small.get(4));//RW
}