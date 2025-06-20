@Test public void testCencelledConnect() throws Exception {
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(1,totals.getPending());
Assert.assertTrue(future.isDone());
Assert.assertTrue(future.isCancelled());
LocalPoolEntry entry=future.get();
Assert.assertNull(entry);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
}