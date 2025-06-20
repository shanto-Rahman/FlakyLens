@Test public void testExtract() throws Exception {
Assert.assertNotNull(contentType);
Assert.assertEquals("text/plain",contentType.getMimeType());
Assert.assertEquals("utf-8",contentType.getCharset());
}