@Test public void testEntityWithUnsupportedTransferEncoding() throws Exception {
Assert.assertEquals(ContentLengthStrategy.CHUNKED,lenStrategy.determineLength(message));
Assert.fail("ProtocolException should have been thrown");
}