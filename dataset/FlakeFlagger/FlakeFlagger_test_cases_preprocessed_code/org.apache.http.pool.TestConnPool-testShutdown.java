@Test public void testShutdown() throws Exception {
LocalPoolEntry entry1=future1.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry1);
LocalPoolEntry entry2=future2.get(1,TimeUnit.SECONDS);
Assert.assertNotNull(entry2);
Assert.assertEquals(1,totals.getAvailable());
Assert.assertEquals(1,totals.getLeased());
Assert.assertTrue(pool.isShutdown());
Assert.fail("IllegalStateException should have been thrown");
}