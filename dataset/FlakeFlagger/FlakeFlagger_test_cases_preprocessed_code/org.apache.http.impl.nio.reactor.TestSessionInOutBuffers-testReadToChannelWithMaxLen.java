@Test public void testReadToChannelWithMaxLen() throws Exception {
Assert.assertEquals(10,inbuf.read(dst,10));
Assert.assertEquals(3,inbuf.read(dst,3));
Assert.assertEquals(3,inbuf.read(dst,10));
Assert.assertEquals(ByteBuffer.wrap(pattern),ByteBuffer.wrap(outstream.toByteArray()));
}