@Test public void testWriteFromChannel() throws Exception {
Assert.assertEquals(ByteBuffer.wrap(pattern),ByteBuffer.wrap(outstream.toByteArray()));
}