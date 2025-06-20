@Test public void testEntityWithContentLength() throws Exception {
Assert.assertNotNull(entity);
Assert.assertEquals(0,entity.getContentLength());
Assert.assertFalse(entity.isChunked());
Assert.assertTrue(entity.getContent() instanceof ContentLengthInputStream);
}