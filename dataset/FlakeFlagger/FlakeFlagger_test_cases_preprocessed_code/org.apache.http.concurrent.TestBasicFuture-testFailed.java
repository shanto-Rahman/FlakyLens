@Test public void testFailed() throws Exception {
Assert.assertFalse(callback.isCompleted());
Assert.assertNull(callback.getResult());
Assert.assertTrue(callback.isFailed());
Assert.assertSame(boom,callback.getException());
Assert.assertFalse(callback.isCancelled());
Assert.assertSame(boom,ex.getCause());
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
}