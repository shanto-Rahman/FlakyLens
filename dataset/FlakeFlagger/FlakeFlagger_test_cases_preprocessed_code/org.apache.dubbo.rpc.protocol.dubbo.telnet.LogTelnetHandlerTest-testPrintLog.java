@Test public void testPrintLog() throws RemotingException {
String result=log.telnet(mockChannel,"100");//RW
assertTrue(result.contains("CURRENT LOG APPENDER"));
}