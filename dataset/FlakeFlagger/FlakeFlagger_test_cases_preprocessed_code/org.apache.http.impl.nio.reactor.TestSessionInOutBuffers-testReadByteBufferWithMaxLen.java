@Test public void testReadByteBufferWithMaxLen() throws Exception {
Assert.assertEquals(10,inbuf.read(dst,10));
Assert.assertEquals(dst,ByteBuffer.wrap(pattern,0,10));
Assert.assertEquals(3,inbuf.read(dst,3));
Assert.assertEquals(dst,ByteBuffer.wrap(pattern,10,3));
Assert.assertEquals(3,inbuf.read(dst,20));
Assert.assertEquals(dst,ByteBuffer.wrap(pattern,13,3));
}