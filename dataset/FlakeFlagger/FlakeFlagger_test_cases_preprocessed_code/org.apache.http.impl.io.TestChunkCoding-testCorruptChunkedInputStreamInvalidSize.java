@Test public void testCorruptChunkedInputStreamInvalidSize() throws IOException {
Assert.fail("MalformedChunkCodingException should have been thrown");
}