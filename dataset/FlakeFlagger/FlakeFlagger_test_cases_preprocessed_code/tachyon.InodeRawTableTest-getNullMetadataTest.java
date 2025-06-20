@Test public void getNullMetadataTest() throws TachyonException {
Assert.assertTrue(inodeRawTable.getMetadata().equals(ByteBuffer.allocate(0)));
}