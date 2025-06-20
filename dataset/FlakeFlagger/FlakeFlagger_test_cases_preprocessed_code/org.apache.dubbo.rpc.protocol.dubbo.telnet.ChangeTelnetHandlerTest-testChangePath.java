@Test public void testChangePath() throws RemotingException {
String result=change.telnet(mockChannel,"demo");//RW
assertEquals("Used the demo as default.\r\nYou can cancel default service by command: cd /",result);
}