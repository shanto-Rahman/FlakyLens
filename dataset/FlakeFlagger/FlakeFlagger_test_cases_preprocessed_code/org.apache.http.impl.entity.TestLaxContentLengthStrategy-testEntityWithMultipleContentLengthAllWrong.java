@Test public void testEntityWithMultipleContentLengthAllWrong() throws Exception {
Assert.assertEquals(ContentLengthStrategy.IDENTITY,lenStrategy.determineLength(message));
Assert.fail("ProtocolException should have been thrown");
}