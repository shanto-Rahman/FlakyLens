@Test public void testExplicitKeepAlive() throws Exception {
Assert.assertTrue(reuseStrategy.keepAlive(response,context));
}