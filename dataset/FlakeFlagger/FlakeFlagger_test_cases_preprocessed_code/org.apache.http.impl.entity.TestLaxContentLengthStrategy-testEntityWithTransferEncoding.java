@Test public void testEntityWithTransferEncoding() throws Exception {
Assert.assertEquals(ContentLengthStrategy.CHUNKED,lenStrategy.determineLength(message));
Assert.assertEquals(ContentLengthStrategy.CHUNKED,lenStrategy.determineLength(message));
}