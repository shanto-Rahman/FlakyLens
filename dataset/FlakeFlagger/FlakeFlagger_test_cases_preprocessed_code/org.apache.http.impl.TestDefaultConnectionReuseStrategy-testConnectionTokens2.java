@Test public void testConnectionTokens2() throws Exception {
Assert.assertTrue(reuseStrategy.keepAlive(response,context));
}