@Test public void testInvalidNegativeContentLength() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}