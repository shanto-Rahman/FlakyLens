@Test public void testWriteByteBuffer() throws Exception {
Assert.assertEquals(ByteBuffer.wrap(pattern),ByteBuffer.wrap(outstream.toByteArray()));
}