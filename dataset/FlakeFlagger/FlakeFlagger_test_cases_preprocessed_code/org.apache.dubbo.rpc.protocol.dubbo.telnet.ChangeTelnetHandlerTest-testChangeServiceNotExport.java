@Test public void testChangeServiceNotExport() throws RemotingException {
String result=change.telnet(mockChannel,"demo");//RW
assertEquals("No such service demo",result);
}