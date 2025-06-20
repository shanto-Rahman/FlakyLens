@Test public void testEntityWithInvalidContentLength() throws Exception {
Assert.assertEquals(ContentLengthStrategy.IDENTITY,lenStrategy.determineLength(message));
Assert.fail("ProtocolException should have been thrown");
}