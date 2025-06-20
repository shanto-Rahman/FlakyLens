@SuppressWarnings("unchecked") @Test public void testList() throws RemotingException {
String result=list.telnet(mockChannel,"");//RW
assertEquals("org.apache.dubbo.rpc.protocol.dubbo.support.DemoService",result);
}