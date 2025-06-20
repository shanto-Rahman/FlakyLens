@Test public void testEntityNoContentDelimiter() throws Exception {
Assert.assertEquals(ContentLengthStrategy.IDENTITY,lenStrategy.determineLength(message));
}