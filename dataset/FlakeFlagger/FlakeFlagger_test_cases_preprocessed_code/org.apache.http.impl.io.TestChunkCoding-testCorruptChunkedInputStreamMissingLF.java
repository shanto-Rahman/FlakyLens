@Test public void testCorruptChunkedInputStreamMissingLF() throws IOException {
Assert.fail("MalformedChunkCodingException should have been thrown");
}