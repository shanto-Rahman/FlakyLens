@Test public void testLeaseTimeout() throws Exception {
t1.start();
t2.start();
t1.join(GRACE_PERIOD);
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry1=t1.getEntry();//IT
Assert.assertNotNull(entry1);
t2.join(GRACE_PERIOD);
Assert.assertTrue(t2.getException() instanceof TimeoutException);//IT
Assert.assertFalse(future2.isDone());
Assert.assertFalse(future2.isCancelled());
}