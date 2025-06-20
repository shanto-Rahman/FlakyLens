@Test public void testChangeMessageNull() throws RemotingException {
String result=change.telnet(mockChannel,null);//RW
assertEquals("Please input service name, eg: \r\ncd XxxService\r\ncd com.xxx.XxxService",result);
}