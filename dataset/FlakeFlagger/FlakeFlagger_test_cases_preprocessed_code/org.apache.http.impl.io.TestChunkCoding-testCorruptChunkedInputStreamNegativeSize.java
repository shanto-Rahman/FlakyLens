@Test public void testCorruptChunkedInputStreamNegativeSize() throws IOException {
Assert.fail("MalformedChunkCodingException should have been thrown");
}