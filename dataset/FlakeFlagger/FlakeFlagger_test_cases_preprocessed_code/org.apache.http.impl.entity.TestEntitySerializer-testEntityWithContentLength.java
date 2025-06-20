@Test public void testEntityWithContentLength() throws Exception {
Assert.assertNotNull(outstream);
Assert.assertTrue(outstream instanceof ContentLengthOutputStream);
}