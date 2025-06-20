@Test public void testReadByteBuffer() throws Exception {
Assert.assertEquals(10,inbuf.read(dst));
Assert.assertEquals(dst,ByteBuffer.wrap(pattern,0,10));
Assert.assertEquals(6,inbuf.read(dst));
Assert.assertEquals(dst,ByteBuffer.wrap(pattern,10,6));
}