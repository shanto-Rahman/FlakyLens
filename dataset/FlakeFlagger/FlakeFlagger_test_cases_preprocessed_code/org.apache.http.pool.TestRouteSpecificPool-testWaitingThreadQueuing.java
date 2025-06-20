@SuppressWarnings("unchecked") @Test public void testWaitingThreadQueuing() throws Exception {
Assert.assertEquals(0,pool.getPendingCount());
Assert.assertEquals(1,pool.getPendingCount());
Assert.assertEquals(1,pool.getPendingCount());
Assert.assertEquals(2,pool.getPendingCount());
Assert.assertSame(future1,pool.nextPending());
Assert.assertEquals(1,pool.getPendingCount());
Assert.assertSame(future2,pool.nextPending());
Assert.assertEquals(0,pool.getPendingCount());
Assert.assertNull(pool.nextPending());
}