@Test public void testEntityNeitherContentLengthNorTransferEncoding() throws Exception {
Assert.assertNotNull(entity);
Assert.assertEquals(-1,entity.getContentLength());
Assert.assertFalse(entity.isChunked());
Assert.assertNotNull(instream);
Assert.assertFalse(instream instanceof ContentLengthInputStream);
Assert.assertFalse(instream instanceof ChunkedInputStream);
Assert.assertTrue(instream instanceof IdentityInputStream);
}