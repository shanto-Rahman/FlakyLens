@SuppressWarnings("unchecked") @Test public void testListDefault() throws RemotingException {
String result=list.telnet(mockChannel,"");//RW
assertEquals("Use default service org.apache.dubbo.rpc.protocol.dubbo.support.DemoService.\r\n\r\n" + methodsName,result);//RW
}