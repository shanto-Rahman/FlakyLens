@Test public void testChunkedContent() throws Exception {
Assert.assertTrue(reuseStrategy.keepAlive(response,context));
}