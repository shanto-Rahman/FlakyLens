@Test public void testCorruptChunkedInputStreamTruncatedChunk() throws IOException {
Assert.assertEquals(2,in.read(buffer));
Assert.fail("MalformedChunkCodingException should have been thrown");
}