@Test public void updateMetadataTest() throws IOException {
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 17),table.getMetadata());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 17),table.getMetadata());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 16),table.getMetadata());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(k % 16),table.getMetadata());
}