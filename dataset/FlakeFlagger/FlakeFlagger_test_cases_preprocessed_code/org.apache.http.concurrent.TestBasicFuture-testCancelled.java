@Test public void testCancelled() throws Exception {
Assert.assertFalse(callback.isCompleted());
Assert.assertNull(callback.getResult());
Assert.assertFalse(callback.isFailed());
Assert.assertNull(callback.getException());
Assert.assertTrue(callback.isCancelled());
Assert.assertNull(future.get());
Assert.assertTrue(future.isDone());
Assert.assertTrue(future.isCancelled());
}