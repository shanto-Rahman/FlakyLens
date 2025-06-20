@Test public void testBrokenConnectionDirective1() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}