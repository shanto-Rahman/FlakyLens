@Test public void testEntityNeitherContentLengthNorTransferEncoding() throws Exception {
Assert.assertEquals(ContentLengthStrategy.IDENTITY,lenStrategy.determineLength(message));
}