@Test public void testEntityWithContentLength() throws Exception {
Assert.assertEquals(0,lenStrategy.determineLength(message));
}