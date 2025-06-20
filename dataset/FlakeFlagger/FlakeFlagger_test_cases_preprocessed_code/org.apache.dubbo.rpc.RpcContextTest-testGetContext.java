@Test public void testGetContext(){
Assert.assertNotNull(rpcContext);
Assert.assertNotNull(RpcContext.getContext());
Assert.assertNotNull(serverRpcContext);
}