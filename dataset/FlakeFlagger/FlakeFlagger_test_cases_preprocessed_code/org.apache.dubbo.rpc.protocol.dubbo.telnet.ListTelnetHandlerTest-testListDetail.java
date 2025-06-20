@SuppressWarnings("unchecked") @Test public void testListDetail() throws RemotingException {
String result=list.telnet(mockChannel,"-l");//RW
assertEquals("org.apache.dubbo.rpc.protocol.dubbo.support.DemoService -> dubbo://127.0.0.1:" + port + "/demo",result);
}