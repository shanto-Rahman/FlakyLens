@Test public void testCorruptChunkedInputStreamInvalidFooter() throws IOException {
Assert.fail("MalformedChunkCodingException should have been thrown");
}