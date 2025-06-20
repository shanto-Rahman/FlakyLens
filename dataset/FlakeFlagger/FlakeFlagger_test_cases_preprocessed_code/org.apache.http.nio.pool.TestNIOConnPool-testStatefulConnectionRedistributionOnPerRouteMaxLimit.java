@Test public void testStatefulConnectionRedistributionOnPerRouteMaxLimit() throws Exception {
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry1=future1.get();
Assert.assertNotNull(entry1);
Assert.assertTrue(future2.isDone());
LocalPoolEntry entry2=future2.get();
Assert.assertNotNull(entry2);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(2,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry3=future3.get();
Assert.assertNotNull(entry3);
Assert.assertTrue(future4.isDone());
LocalPoolEntry entry4=future4.get();
Assert.assertNotNull(entry4);
Assert.assertEquals(2,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
Assert.assertFalse(future5.isDone());
Assert.assertEquals(1,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(1,totals.getPending());
}