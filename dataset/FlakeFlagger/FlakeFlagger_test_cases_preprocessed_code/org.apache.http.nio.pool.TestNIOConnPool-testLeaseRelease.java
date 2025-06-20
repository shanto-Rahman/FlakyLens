@Test public void testLeaseRelease() throws Exception {
LocalPoolEntry entry1=future1.get();
Assert.assertNotNull(entry1);
LocalPoolEntry entry2=future2.get();
Assert.assertNotNull(entry2);
LocalPoolEntry entry3=future3.get();
Assert.assertNotNull(entry3);
Assert.assertEquals(2,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
}