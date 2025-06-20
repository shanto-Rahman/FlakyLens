@Test public void testBasicsDirect() throws Exception {
Assert.assertEquals(-1,httpentity.getContentLength());
Assert.assertNotNull(httpentity.getContent());
Assert.assertTrue(httpentity.isRepeatable());
Assert.assertFalse(httpentity.isStreaming());
}