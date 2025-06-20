@Test public void testExplicitClose() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}