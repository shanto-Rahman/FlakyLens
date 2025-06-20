@Test public void testAddFirstRequestInterceptorNull(){
Assert.assertEquals(0,itcpCount);
Assert.assertEquals(null,instance.getRequestInterceptor(0));
}