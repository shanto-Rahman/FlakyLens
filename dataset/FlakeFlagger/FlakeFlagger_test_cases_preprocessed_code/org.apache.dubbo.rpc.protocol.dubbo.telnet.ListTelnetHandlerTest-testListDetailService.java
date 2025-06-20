@SuppressWarnings("unchecked") @Test public void testListDetailService() throws RemotingException {
String result=list.telnet(mockChannel,"-l DemoService");//RW
assertEquals(detailMethods,result);//RW
}