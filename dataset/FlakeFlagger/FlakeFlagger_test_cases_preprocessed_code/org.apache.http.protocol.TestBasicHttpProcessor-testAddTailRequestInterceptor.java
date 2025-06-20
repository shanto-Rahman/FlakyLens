@Test public void testAddTailRequestInterceptor(){
Assert.assertEquals(1,instance.getRequestInterceptorCount());
Assert.assertSame(itcp1,instance.getRequestInterceptor(0));
Assert.assertEquals(2,itcpCount);
Assert.assertSame(itcp1,instance.getRequestInterceptor(0));
Assert.assertSame(itcp2,instance.getRequestInterceptor(itcpCount - 1));
}