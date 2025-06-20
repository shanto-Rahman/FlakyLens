@Test public void testEntityWithTransferEncoding() throws Exception {
Assert.assertNotNull(entity);
Assert.assertEquals(-1,entity.getContentLength());
Assert.assertTrue(entity.isChunked());
Assert.assertTrue(entity.getContent() instanceof ChunkedInputStream);
Assert.assertNotNull(entity);
Assert.assertEquals(-1,entity.getContentLength());
Assert.assertTrue(entity.isChunked());
Assert.assertTrue(entity.getContent() instanceof ChunkedInputStream);
}