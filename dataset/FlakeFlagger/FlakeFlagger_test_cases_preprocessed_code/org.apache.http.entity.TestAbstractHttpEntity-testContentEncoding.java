@Test public void testContentEncoding() throws Exception {
Assert.assertEquals(HTTP.CONTENT_ENCODING,httpentity.getContentEncoding().getName());
Assert.assertEquals("gzip",httpentity.getContentEncoding().getValue());
Assert.assertEquals(HTTP.CONTENT_ENCODING,httpentity.getContentEncoding().getName());
Assert.assertEquals("gzip",httpentity.getContentEncoding().getValue());
Assert.assertNull(httpentity.getContentEncoding());
Assert.assertNull(httpentity.getContentEncoding());
}