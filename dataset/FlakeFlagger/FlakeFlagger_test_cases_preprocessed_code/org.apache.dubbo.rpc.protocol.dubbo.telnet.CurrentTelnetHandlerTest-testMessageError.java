@Test public void testMessageError() throws RemotingException {
String result=count.telnet(mockChannel,"test");//RW
assertEquals("Unsupported parameter test for pwd.",result);
}