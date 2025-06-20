@Test public void testSuccessfulConnect() throws Exception {
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(1,totals.getPending());
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
LocalPoolEntry entry=future.get();
Assert.assertNotNull(entry);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(1,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
}