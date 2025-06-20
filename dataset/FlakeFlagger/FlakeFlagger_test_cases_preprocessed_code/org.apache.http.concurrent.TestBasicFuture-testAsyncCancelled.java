@Test public void testAsyncCancelled() throws Exception {
Thread.sleep(100);
t.setDaemon(true);
t.start();
Assert.assertNull(future.get(60,TimeUnit.SECONDS));
Assert.assertTrue(future.isDone());
Assert.assertTrue(future.isCancelled());
}