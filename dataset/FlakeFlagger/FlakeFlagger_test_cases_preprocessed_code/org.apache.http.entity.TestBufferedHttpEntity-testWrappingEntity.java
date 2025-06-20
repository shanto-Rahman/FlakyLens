@Test public void testWrappingEntity() throws Exception {
Assert.assertEquals(bytes.length,bufentity.getContentLength());
Assert.assertTrue(bufentity.isRepeatable());
Assert.assertTrue(bufentity.isChunked());
Assert.assertFalse(bufentity.isStreaming());
Assert.assertNotNull(bufentity.getContent());
Assert.assertNotNull(bufentity.getContent());
}