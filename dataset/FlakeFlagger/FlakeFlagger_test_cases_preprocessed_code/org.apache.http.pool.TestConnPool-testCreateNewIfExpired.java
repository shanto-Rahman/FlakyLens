@Test public void testCreateNewIfExpired() throws Exception {
LocalPoolEntry entry1=future1.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry1);
Thread.sleep(200L);
LocalPoolEntry entry2=future2.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry2);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(1,totals.getLeased());
Assert.assertEquals(0,stats.getAvailable());
Assert.assertEquals(1,stats.getLeased());
}