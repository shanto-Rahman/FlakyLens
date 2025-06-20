@Test public void testCloseIdle() throws Exception {
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry1=future1.get();
Assert.assertNotNull(entry1);
Assert.assertTrue(future2.isDone());
LocalPoolEntry entry2=future2.get();
Assert.assertNotNull(entry2);
Thread.sleep(200L);
Assert.assertEquals(1,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
Assert.assertEquals(1,stats.getAvailable());
Assert.assertEquals(0,stats.getLeased());
Assert.assertEquals(0,stats.getPending());
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
Assert.assertEquals(0,stats.getAvailable());
Assert.assertEquals(0,stats.getLeased());
Assert.assertEquals(0,stats.getPending());
}