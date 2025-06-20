@Test public void testConnectionRedistributionOnTotalMaxLimit() throws Exception {
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
t3.start();
t4.start();
Assert.assertFalse(t3.isDone());//IT
Assert.assertFalse(t4.isDone());//IT
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(2,totals.getLeased());
t3.join(GRACE_PERIOD);
Assert.assertTrue(future3.isDone());
LocalPoolEntry entry3=t3.getEntry();//IT
Assert.assertNotNull(entry3);
t4.join(GRACE_PERIOD);
Assert.assertTrue(future4.isDone());
LocalPoolEntry entry4=t4.getEntry();//IT
Assert.assertNotNull(entry4);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(2,totals.getLeased());
t5.start();
t6.start();
t5.join(GRACE_PERIOD);
Assert.assertTrue(future5.isDone());
LocalPoolEntry entry5=t5.getEntry();//IT
Assert.assertNotNull(entry5);
t6.join(GRACE_PERIOD);
Assert.assertTrue(future6.isDone());
LocalPoolEntry entry6=t6.getEntry();//IT
Assert.assertNotNull(entry6);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(2,totals.getLeased());
Assert.assertEquals(2,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
}