@Test public void testAsyncFailed() throws Exception {
Thread.sleep(100);
t.setDaemon(true);
t.start();
Assert.assertSame(boom,ex.getCause());
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
}