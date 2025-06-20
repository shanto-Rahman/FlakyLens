@Test public void testBasics() throws Exception {
Assert.assertEquals(bytes.length,httpentity.getContentLength());
Assert.assertFalse(httpentity.isRepeatable());
Assert.assertTrue(httpentity.isStreaming());
}