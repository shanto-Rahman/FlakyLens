@Test public void testEntityWithMultipleContentLength() throws Exception {
Assert.assertNotNull(entity);
Assert.assertEquals(1,entity.getContentLength());
Assert.assertFalse(entity.isChunked());
Assert.assertNotNull(instream);
Assert.assertTrue(instream instanceof ContentLengthInputStream);
Assert.fail("ProtocolException should have been thrown");
}