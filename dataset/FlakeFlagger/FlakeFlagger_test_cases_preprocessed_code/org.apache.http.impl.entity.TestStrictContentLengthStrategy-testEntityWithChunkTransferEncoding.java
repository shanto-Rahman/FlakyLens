@Test public void testEntityWithChunkTransferEncoding() throws Exception {
Assert.assertEquals(ContentLengthStrategy.CHUNKED,lenStrategy.determineLength(message));
}