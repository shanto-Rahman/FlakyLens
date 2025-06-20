@Test public void testAdd() throws Exception {
Assert.assertEquals(1,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(1,pool.getLeasedCount());
Assert.assertEquals(0,pool.getPendingCount());
Assert.assertNotNull(entry);
Assert.assertSame(conn,entry.getConnection());
}