@Test public void testCancelledConnect() throws Exception {
Assert.assertEquals(1,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(0,pool.getLeasedCount());
Assert.assertEquals(1,pool.getPendingCount());
Assert.assertTrue(future.isDone());
Assert.assertTrue(future.isCancelled());
Assert.assertEquals(0,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(0,pool.getLeasedCount());
Assert.assertEquals(0,pool.getPendingCount());
}