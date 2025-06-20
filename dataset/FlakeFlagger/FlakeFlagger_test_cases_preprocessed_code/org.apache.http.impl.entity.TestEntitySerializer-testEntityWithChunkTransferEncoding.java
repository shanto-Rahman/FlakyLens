@Test public void testEntityWithChunkTransferEncoding() throws Exception {
Assert.assertNotNull(outstream);
Assert.assertTrue(outstream instanceof ChunkedOutputStream);
}