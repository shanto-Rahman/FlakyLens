@Test public void testMalformedChunkTruncatedChunk() throws Exception {
Assert.assertEquals(2,decoder.read(dst));
Assert.fail("MalformedChunkCodingException should have been thrown");
}