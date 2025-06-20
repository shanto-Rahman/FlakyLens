@Test public void overReturnSpaceTest() throws TException {
Assert.assertTrue(mWorkerServiceHandler.requestSpace(1,WORKER_CAPACITY_BYTES / 10));
Assert.assertTrue(mWorkerServiceHandler.requestSpace(2,WORKER_CAPACITY_BYTES / 10));
Assert.assertFalse(mWorkerServiceHandler.requestSpace(1,WORKER_CAPACITY_BYTES));
}