@Test public void testRmiProtocol() throws Exception {
assertEquals(service.getSize(null),-1);
assertEquals(service.getSize(new String[]{"","",""}),3);
assertEquals("rmi://127.0.0.1:9001/TestService:invoke",result);
assertEquals("hello abcd@" + RemoteServiceImpl.class.getName(),say);
}