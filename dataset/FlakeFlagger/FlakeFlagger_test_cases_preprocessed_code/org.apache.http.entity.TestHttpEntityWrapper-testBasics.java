@Test public void testBasics() throws Exception {
Assert.assertEquals(httpentity.getContentLength(),wrapped.getContentLength());
Assert.assertEquals(httpentity.getContentType(),wrapped.getContentType());
Assert.assertEquals(httpentity.getContentEncoding(),wrapped.getContentEncoding());
Assert.assertEquals(httpentity.isChunked(),wrapped.isChunked());
Assert.assertEquals(httpentity.isRepeatable(),wrapped.isRepeatable());
Assert.assertEquals(httpentity.isStreaming(),wrapped.isStreaming());
Assert.assertNotNull(wrapped.getContent());
}