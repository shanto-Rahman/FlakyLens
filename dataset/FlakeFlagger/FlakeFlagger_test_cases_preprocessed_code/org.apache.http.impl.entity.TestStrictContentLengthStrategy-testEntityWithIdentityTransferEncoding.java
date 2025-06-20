@Test public void testEntityWithIdentityTransferEncoding() throws Exception {
Assert.assertEquals(ContentLengthStrategy.IDENTITY,lenStrategy.determineLength(message));
}