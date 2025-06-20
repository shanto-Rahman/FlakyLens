@Test public void testLeaseRequestTimeout() throws Exception {
Assert.assertTrue(future1.isDone());
LocalPoolEntry entry1=future1.get();
Assert.assertNotNull(entry1);
Assert.assertFalse(future2.isDone());
Assert.assertFalse(future3.isDone());
Thread.sleep(100);
Assert.assertFalse(future2.isDone());
Assert.assertTrue(future3.isDone());
}