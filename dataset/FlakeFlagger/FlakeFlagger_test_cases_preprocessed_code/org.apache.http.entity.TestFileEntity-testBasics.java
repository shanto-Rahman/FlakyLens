@Test public void testBasics() throws Exception {
Assert.assertEquals(tmpfile.length(),httpentity.getContentLength());
Assert.assertNotNull(content);
Assert.assertTrue(httpentity.isRepeatable());
Assert.assertFalse(httpentity.isStreaming());
if (!tmpfile.delete()) {
Assert.fail("Failed to delete: " + tmpfile);
}
}