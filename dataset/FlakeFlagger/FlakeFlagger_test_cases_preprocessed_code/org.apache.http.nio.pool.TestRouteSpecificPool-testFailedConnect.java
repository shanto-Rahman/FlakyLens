@Test public void testFailedConnect() throws Exception {
Assert.assertEquals(1,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(0,pool.getLeasedCount());
Assert.assertEquals(1,pool.getPendingCount());
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
Assert.fail("ExecutionException should have been thrown");
Assert.assertTrue(ex.getCause() instanceof IOException);
Assert.assertEquals(0,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(0,pool.getLeasedCount());
Assert.assertEquals(0,pool.getPendingCount());
}