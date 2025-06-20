@Test public void testChunkingFlag() throws Exception {
Assert.assertFalse(httpentity.isChunked());
Assert.assertTrue(httpentity.isChunked());
}