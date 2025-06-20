@Test public void testReadToChannel() throws Exception {
Assert.assertEquals(16,inbuf.read(dst));
Assert.assertEquals(ByteBuffer.wrap(pattern),ByteBuffer.wrap(outstream.toByteArray()));
}