@Test public void testLeaseIOException() throws Exception {
t1.start();
t1.join(GRACE_PERIOD);
Assert.assertTrue(future1.isDone());
Assert.assertTrue(t1.getException() instanceof ExecutionException);//IT
Assert.assertTrue(t1.getException().getCause() instanceof IOException);//IT
Assert.assertFalse(future1.isCancelled());
}