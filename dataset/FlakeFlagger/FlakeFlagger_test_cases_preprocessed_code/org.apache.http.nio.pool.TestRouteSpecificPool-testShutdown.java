@Test public void testShutdown() throws Exception {
Assert.assertNotNull(entry1);
Assert.assertNotNull(entry2);
Assert.assertEquals(3,pool.getAllocatedCount());
Assert.assertEquals(1,pool.getAvailableCount());
Assert.assertEquals(1,pool.getLeasedCount());
Assert.assertEquals(1,pool.getPendingCount());
Assert.assertEquals(0,pool.getAllocatedCount());
Assert.assertEquals(0,pool.getAvailableCount());
Assert.assertEquals(0,pool.getLeasedCount());
Assert.assertEquals(0,pool.getPendingCount());
}