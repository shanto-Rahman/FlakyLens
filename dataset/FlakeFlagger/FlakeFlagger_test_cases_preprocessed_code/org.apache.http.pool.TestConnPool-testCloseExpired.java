@Test public void testCloseExpired() throws Exception {
LocalPoolEntry entry1=future1.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry1);
LocalPoolEntry entry2=future2.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry2);
Thread.sleep(200);
Assert.assertEquals(1,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(1,stats.getAvailable());
Assert.assertEquals(0,stats.getLeased());
}