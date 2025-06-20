@Test public void testAsync(){
Assertions.assertFalse(rpcContext.isAsyncStarted());
Assertions.assertTrue(rpcContext.isAsyncStarted());
Assertions.assertTrue(((AsyncContextImpl)asyncContext).getInternalFuture().isDone());
Assertions.assertTrue(rpcContext.isAsyncStarted());
}