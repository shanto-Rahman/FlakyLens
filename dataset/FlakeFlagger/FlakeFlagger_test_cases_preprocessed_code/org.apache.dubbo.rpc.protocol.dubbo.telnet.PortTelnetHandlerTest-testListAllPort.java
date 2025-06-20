@Test public void testListAllPort() throws RemotingException {
String result=port.telnet(null,"");//RW
assertEquals("20887",result);
}