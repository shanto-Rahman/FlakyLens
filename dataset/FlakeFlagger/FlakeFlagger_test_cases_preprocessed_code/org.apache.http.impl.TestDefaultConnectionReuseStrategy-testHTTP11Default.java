@Test public void testHTTP11Default() throws Exception {
Assert.assertTrue(reuseStrategy.keepAlive(response,context));
}