@SuppressWarnings("unchecked") @Test public void testInvokeAutoFindMethod() throws RemotingException {
given(mockInvoker.invoke(any(Invocation.class))).willReturn(new RpcResult("ok"));//RW
String result=invoke.telnet(mockChannel,"echo(\"ok\")");//RW
assertTrue(result.contains("ok"));
}