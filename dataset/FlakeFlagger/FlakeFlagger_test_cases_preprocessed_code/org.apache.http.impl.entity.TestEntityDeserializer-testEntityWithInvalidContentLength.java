@Test public void testEntityWithInvalidContentLength() throws Exception {
Assert.assertNotNull(entity);
Assert.assertEquals(-1,entity.getContentLength());
Assert.assertFalse(entity.isChunked());
Assert.assertNotNull(instream);
Assert.assertFalse(instream instanceof ContentLengthInputStream);
Assert.assertTrue(instream instanceof IdentityInputStream);
Assert.fail("ProtocolException should have been thrown");
}