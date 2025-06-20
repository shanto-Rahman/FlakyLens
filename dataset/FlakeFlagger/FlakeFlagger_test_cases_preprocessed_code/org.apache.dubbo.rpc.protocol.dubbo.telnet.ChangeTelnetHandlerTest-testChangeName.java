@Test public void testChangeName() throws RemotingException {
String result=change.telnet(mockChannel,"org.apache.dubbo.rpc.protocol.dubbo.support.DemoService");//RW
assertEquals("Used the org.apache.dubbo.rpc.protocol.dubbo.support.DemoService as default.\r\nYou can cancel default service by command: cd /",result);
}