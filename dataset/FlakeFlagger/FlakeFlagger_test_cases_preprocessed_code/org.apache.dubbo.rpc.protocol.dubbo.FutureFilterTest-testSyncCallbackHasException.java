@Test(expected=RuntimeException.class) public void testSyncCallbackHasException() throws RpcException, Throwable {
given(invoker.invoke(invocation)).willReturn(result);//RW
eventFilter.invoke(invoker,invocation).recreate();//RW
}