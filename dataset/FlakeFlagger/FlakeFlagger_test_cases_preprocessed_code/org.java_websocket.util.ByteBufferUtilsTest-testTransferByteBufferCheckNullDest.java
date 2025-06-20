@Test public void testTransferByteBufferCheckNullDest(){
ByteBuffer source=ByteBuffer.wrap(smallArray);//RW
fail("IllegalArgumentException should be thrown");
}