@Test public void testChunkedTransferEncodingMustBeLast() throws Exception {
Assert.assertNotNull(entity);
Assert.assertEquals(-1,entity.getContentLength());
Assert.assertFalse(entity.isChunked());
Assert.assertFalse(entity.getContent() instanceof ChunkedInputStream);
Assert.fail("ProtocolException should have been thrown");
}