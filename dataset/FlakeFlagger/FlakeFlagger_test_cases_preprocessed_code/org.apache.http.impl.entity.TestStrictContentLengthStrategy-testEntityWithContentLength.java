@Test public void testEntityWithContentLength() throws Exception {
Assert.assertEquals(100,lenStrategy.determineLength(message));
}