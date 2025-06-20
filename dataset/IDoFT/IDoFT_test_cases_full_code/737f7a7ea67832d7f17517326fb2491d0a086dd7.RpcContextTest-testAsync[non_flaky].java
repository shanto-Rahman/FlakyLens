@Test public void testAsync(){
  RpcContext rpcContext=RpcContext.getContext();
  Assertions.assertFalse(rpcContext.isAsyncStarted());
  AsyncContext asyncContext=RpcContext.startAsync();
  Assertions.assertTrue(rpcContext.isAsyncStarted());
  asyncContext.write(new Object());
  Assertions.assertTrue(((AsyncContextImpl)asyncContext).getInternalFuture().isDone());
  rpcContext.stopAsync();
  Assertions.assertTrue(rpcContext.isAsyncStarted());
  RpcContext.removeContext();
}
