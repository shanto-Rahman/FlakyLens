@Test public void testCreateNewIfExpired() throws Exception {
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry1=future1.get();
Assert.assertNotNull(entry1);
Thread.sleep(200L);
Assert.assertFalse(future2.isDone());
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(1,totals.getPending());
Assert.assertEquals(0,stats.getAvailable());
Assert.assertEquals(0,stats.getLeased());
Assert.assertEquals(1,stats.getPending());
}