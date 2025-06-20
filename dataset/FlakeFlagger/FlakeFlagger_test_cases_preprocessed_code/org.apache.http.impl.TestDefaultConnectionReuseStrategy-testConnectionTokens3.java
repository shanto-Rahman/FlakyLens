@Test public void testConnectionTokens3() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}