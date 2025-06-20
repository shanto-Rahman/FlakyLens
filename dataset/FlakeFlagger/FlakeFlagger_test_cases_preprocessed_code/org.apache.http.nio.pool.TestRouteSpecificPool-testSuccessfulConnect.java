@Test public void testSuccessfulConnect() throws Exception {
Assert.assertEquals(1,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(0,pool.getLeasedCount());
Assert.assertEquals(1,pool.getPendingCount());
Assert.assertNotNull(entry);
Assert.assertSame(session,entry.getConnection());
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
Assert.assertEquals(1,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(1,pool.getLeasedCount());
Assert.assertEquals(0,pool.getPendingCount());
}