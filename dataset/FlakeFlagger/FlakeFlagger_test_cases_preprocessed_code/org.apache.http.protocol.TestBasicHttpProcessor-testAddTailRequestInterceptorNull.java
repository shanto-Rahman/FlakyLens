@Test public void testAddTailRequestInterceptorNull(){
Assert.assertEquals(0,itcpCount);
Assert.assertEquals(null,instance.getRequestInterceptor(itcpCount - 1));
}