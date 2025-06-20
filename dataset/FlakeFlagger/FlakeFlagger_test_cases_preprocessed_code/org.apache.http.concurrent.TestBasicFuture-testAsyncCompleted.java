@Test public void testAsyncCompleted() throws Exception {
Thread.sleep(100);
t.setDaemon(true);
t.start();
Assert.assertSame(result,future.get(60,TimeUnit.SECONDS));
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
}