@Test public void testBrokenConnectionDirective2() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}