@Test public void testIgnoreInvalidKeepAlive() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}