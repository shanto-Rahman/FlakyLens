@Test public void testStatefulConnectionRedistributionOnPerRouteMaxLimit() throws Exception {
t1.start();
t2.start();
t1.join(GRACE_PERIOD);
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry1=t1.getEntry();//IT
Assert.assertNotNull(entry1);
t2.join(GRACE_PERIOD);
Assert.assertTrue(future2.isDone());
LocalPoolEntry entry2=t2.getEntry();//IT
Assert.assertNotNull(entry2);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(2,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
t3.start();
t3.join(GRACE_PERIOD);
Assert.assertTrue(future3.isDone());
LocalPoolEntry entry3=t3.getEntry();//IT
Assert.assertNotNull(entry3);
Assert.assertEquals(1,totals.getAvailable());
Assert.assertEquals(1,totals.getLeased());
}