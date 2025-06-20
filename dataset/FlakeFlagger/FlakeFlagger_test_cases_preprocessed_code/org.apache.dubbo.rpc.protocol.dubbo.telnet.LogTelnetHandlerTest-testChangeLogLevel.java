@Test public void testChangeLogLevel() throws RemotingException {
String result=log.telnet(mockChannel,"error");//RW
assertTrue(result.contains("\r\nCURRENT LOG LEVEL:ERROR"));
String result2=log.telnet(mockChannel,"warn");//RW
assertTrue(result2.contains("\r\nCURRENT LOG LEVEL:WARN"));
}