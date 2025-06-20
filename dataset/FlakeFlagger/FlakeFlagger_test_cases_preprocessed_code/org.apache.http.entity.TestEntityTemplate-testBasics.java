@Test public void testBasics() throws Exception {
Assert.assertEquals(-1,httpentity.getContentLength());
Assert.assertTrue(httpentity.isRepeatable());
Assert.assertFalse(httpentity.isStreaming());
}