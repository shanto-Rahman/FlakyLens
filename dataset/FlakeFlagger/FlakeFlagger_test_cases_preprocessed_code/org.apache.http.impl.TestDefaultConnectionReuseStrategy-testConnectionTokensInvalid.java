@Test public void testConnectionTokensInvalid() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}