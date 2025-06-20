@SuppressWarnings("unchecked") @Test public void testInvokeDefaultSService() throws RemotingException {
given(mockInvoker.invoke(any(Invocation.class))).willReturn(new RpcResult("ok"));//RW
String result=invoke.telnet(mockChannel,"DemoService.echo(\"ok\")");//RW
assertTrue(result.contains("Use default service org.apache.dubbo.rpc.protocol.dubbo.support.DemoService.\r\n\"ok\"\r\n"));
}