@Test public void testBasicsBuff() throws Exception {
Assert.assertEquals(baos.toByteArray().length,httpentity.getContentLength());
Assert.assertNotNull(httpentity.getContent());
Assert.assertTrue(httpentity.isRepeatable());
Assert.assertFalse(httpentity.isStreaming());
}