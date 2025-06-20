@Test public void testLeaseRelease() throws Exception {
LocalPoolEntry entry1=future1.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry1);
LocalPoolEntry entry2=future2.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry2);
LocalPoolEntry entry3=future3.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry3);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(3,totals.getLeased());
LocalPoolEntry entry=future1.get();
Assert.assertSame(entry1,entry);
Assert.assertEquals(2,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
}