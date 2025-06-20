@Test public void testDecodeFrame() throws Exception {
assertEquals(ByteBuffer.wrap("test".getBytes()),binaryFrame.getPayloadData());
}