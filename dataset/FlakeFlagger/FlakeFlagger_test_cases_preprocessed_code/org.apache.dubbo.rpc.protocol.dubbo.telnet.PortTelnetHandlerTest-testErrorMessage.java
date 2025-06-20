@Test public void testErrorMessage() throws RemotingException {
String result=port.telnet(null,"a");//RW
assertEquals("Illegal port a, must be integer.",result);
}