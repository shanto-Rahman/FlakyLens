@Test public void testInvaildMessage() throws RemotingException {
String result=list.telnet(mockChannel,"xx");//RW
assertEquals("No such service xx",result);
}