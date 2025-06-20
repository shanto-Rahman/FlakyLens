@Test public void testConnectionTokens4() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}