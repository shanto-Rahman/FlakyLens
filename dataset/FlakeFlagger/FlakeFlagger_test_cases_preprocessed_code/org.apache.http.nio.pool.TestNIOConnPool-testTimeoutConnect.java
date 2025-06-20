@Test public void testTimeoutConnect() throws Exception {
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(1,totals.getPending());
Assert.assertTrue(future.isDone());
Assert.assertFalse(future.isCancelled());
future.get();
Assert.fail("ExecutionException should have been thrown");
Assert.assertTrue(ex.getCause() instanceof SocketTimeoutException);
Assert.assertEquals(0,totals.getAvailable());
Assert.assertEquals(0,totals.getLeased());
Assert.assertEquals(0,totals.getPending());
}