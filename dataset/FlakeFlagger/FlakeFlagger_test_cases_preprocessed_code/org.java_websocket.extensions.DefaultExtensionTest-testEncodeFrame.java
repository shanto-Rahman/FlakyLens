@Test public void testEncodeFrame() throws Exception {
assertEquals(ByteBuffer.wrap("test".getBytes()),binaryFrame.getPayloadData());
}