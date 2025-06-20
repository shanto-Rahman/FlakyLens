@Test public void testCorruptChunkedInputStreamMissingCRLF() throws IOException {
Assert.fail("MalformedChunkCodingException should have been thrown");
}