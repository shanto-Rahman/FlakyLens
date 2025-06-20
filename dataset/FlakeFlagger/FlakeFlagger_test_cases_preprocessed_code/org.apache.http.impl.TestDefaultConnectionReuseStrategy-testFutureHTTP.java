@Test public void testFutureHTTP() throws Exception {
Assert.assertTrue(reuseStrategy.keepAlive(response,context));
}