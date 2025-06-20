@Test public void testCompletedWithTimeout() throws Exception {
Assert.assertFalse(future.isDone());
Assert.assertTrue(callback.isCompleted());
Assert.assertSame(result,callback.getResult());
Assert.assertFalse(callback.isFailed());
Assert.assertNull(callback.getException());
Assert.assertFalse(callback.isCancelled());
Assert.assertSame(result,future.get(1,TimeUnit.MILLISECONDS));
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
}