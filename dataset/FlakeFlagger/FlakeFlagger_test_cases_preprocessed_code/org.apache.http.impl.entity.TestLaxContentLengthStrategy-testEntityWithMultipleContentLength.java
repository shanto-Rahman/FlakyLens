@Test public void testEntityWithMultipleContentLength() throws Exception {
Assert.assertEquals(1,lenStrategy.determineLength(message));
Assert.fail("ProtocolException should have been thrown");
}