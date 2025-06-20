@Test public void testHTTP10Default() throws Exception {
Assert.assertFalse(reuseStrategy.keepAlive(response,context));
}