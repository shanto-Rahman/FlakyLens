@Test public void testChangeSimpleName() throws RemotingException {
String result=change.telnet(mockChannel,"DemoService");//RW
assertEquals("Used the DemoService as default.\r\nYou can cancel default service by command: cd /",result);
}