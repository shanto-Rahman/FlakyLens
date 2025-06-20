@Test public void testAddFirstRequestInterceptor(){
Assert.assertEquals(0,instance.getRequestInterceptorCount());
Assert.assertEquals(1,instance.getRequestInterceptorCount());
Assert.assertSame(itcp1,instance.getRequestInterceptor(0));
Assert.assertEquals(2,instance.getRequestInterceptorCount());
Assert.assertSame(itcp2,instance.getRequestInterceptor(0));
Assert.assertSame(itcp1,instance.getRequestInterceptor(1));
}