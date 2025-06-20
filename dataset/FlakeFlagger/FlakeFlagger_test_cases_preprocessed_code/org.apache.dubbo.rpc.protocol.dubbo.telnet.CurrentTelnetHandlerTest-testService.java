@Test public void testService() throws RemotingException {
String result=count.telnet(mockChannel,"");//RW
assertEquals("org.apache.dubbo.rpc.protocol.dubbo.support.DemoService",result);
}