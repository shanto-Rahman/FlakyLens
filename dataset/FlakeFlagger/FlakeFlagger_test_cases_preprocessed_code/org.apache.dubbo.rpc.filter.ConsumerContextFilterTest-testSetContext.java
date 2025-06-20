@Test public void testSetContext(){
assertEquals(invoker,RpcContext.getContext().getInvoker());
assertEquals(invocation,RpcContext.getContext().getInvocation());
assertEquals(NetUtils.getLocalHost() + ":0",RpcContext.getContext().getLocalAddressString());
assertEquals("test:11",RpcContext.getContext().getRemoteAddressString());
}