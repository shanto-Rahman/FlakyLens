@Test public void testEntityWithIdentityTransferEncoding() throws Exception {
Assert.assertNotNull(entity);
Assert.assertEquals(-1,entity.getContentLength());
Assert.assertFalse(entity.isChunked());
}