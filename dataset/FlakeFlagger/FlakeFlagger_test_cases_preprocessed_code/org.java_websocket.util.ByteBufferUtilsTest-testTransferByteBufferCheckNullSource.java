@Test public void testTransferByteBufferCheckNullSource(){
ByteBuffer dest=ByteBuffer.wrap(smallArray);//RW
fail("IllegalArgumentException should be thrown");
}