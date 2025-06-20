@Test public void getMetadataTest() throws IOException {
Assert.assertEquals(ByteBuffer.allocate(0),table.getMetadata());
Assert.assertEquals(ByteBuffer.allocate(0),table.getMetadata());
Assert.assertEquals(ByteBuffer.allocate(0),table.getMetadata());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 7),table.getMetadata());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 7),table.getMetadata());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 7),table.getMetadata());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 7),table.getMetadata());
}