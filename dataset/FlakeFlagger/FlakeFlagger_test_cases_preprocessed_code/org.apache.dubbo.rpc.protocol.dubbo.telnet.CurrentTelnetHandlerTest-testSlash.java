@Test public void testSlash() throws RemotingException {
String result=count.telnet(mockChannel,"");//RW
assertEquals("/",result);
}