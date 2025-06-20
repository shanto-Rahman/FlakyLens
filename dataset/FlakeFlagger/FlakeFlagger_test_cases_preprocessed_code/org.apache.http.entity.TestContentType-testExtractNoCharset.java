@Test public void testExtractNoCharset() throws Exception {
Assert.assertNotNull(contentType);
Assert.assertEquals("text/plain",contentType.getMimeType());
Assert.assertNull(contentType.getCharset());
}