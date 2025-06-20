@Test(expected=RpcException.class) public void testInvokeExceptoin(){
Assert.assertSame(invoker1,RpcContext.getContext().getInvoker());
}