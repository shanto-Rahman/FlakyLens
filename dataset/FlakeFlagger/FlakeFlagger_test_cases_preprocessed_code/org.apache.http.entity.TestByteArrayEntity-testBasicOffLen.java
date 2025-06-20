@Test public void testBasicOffLen() throws Exception {
Assert.assertEquals(7,httpentity.getContentLength());
Assert.assertNotNull(httpentity.getContent());
Assert.assertTrue(httpentity.isRepeatable());
Assert.assertFalse(httpentity.isStreaming());
}