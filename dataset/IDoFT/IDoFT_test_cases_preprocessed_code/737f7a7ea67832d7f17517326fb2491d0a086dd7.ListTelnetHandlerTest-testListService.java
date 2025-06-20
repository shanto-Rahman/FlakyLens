@SuppressWarnings("unchecked") @Test public void testListService() throws RemotingException {
String result=list.telnet(mockChannel,"DemoService");//RW
assertEquals(methodsName,result);//RW
}