@Test public void testInvaildMessage() throws RemotingException {
String result=invoke.telnet(mockChannel,"(");//RW
assertEquals("Invalid parameters, format: service.method(args)",result);
}