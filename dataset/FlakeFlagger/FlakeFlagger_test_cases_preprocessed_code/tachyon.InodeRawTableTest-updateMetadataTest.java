@Test public void updateMetadataTest() throws TachyonException {
Assert.assertEquals(ByteBuffer.allocate(0),inodeRawTable.getMetadata());
Assert.assertEquals(metadata,inodeRawTable.getMetadata());
}