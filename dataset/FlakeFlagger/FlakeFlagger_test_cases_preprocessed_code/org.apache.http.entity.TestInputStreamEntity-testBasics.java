@Test public void testBasics() throws Exception {
Assert.assertEquals(bytes.length,httpentity.getContentLength());
Assert.assertEquals(instream,httpentity.getContent());
Assert.assertNotNull(httpentity.getContent());
Assert.assertFalse(httpentity.isRepeatable());
Assert.assertTrue(httpentity.isStreaming());
}