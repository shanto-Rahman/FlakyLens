@Test public void testConnectionTokens1() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}