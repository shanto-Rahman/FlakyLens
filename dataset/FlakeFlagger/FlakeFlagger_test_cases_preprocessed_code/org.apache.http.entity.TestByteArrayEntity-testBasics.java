@Test public void testBasics() throws Exception {
Assert.assertEquals(bytes.length,httpentity.getContentLength());
Assert.assertNotNull(httpentity.getContent());
Assert.assertTrue(httpentity.isRepeatable());
Assert.assertFalse(httpentity.isStreaming());
}