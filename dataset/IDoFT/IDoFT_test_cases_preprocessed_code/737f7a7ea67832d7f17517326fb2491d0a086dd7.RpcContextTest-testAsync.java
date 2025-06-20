@Test public void testAsync(){
Assert.assertFalse(rpcContext.isAsyncStarted());
Assert.assertFalse(rpcContext.isAsyncStarted());
Assert.assertTrue(rpcContext.isAsyncStarted());
Assert.assertTrue(future.isDone());
Assert.assertTrue(rpcContext.isAsyncStarted());
}