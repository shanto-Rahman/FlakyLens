@Test public void testLeaseCacnel() throws Exception {
t1.start();
t1.join(GRACE_PERIOD);
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry1=t1.getEntry();//IT
Assert.assertNotNull(entry1);
t2.start();
Thread.sleep(5);
Assert.assertFalse(future2.isDone());
Assert.assertFalse(future2.isCancelled());
future2.cancel(true);
t2.join(GRACE_PERIOD);
Assert.assertTrue(future2.isDone());
Assert.assertTrue(future2.isCancelled());
future2.cancel(true);
future2.cancel(true);
}