@Test public void testClearByClass(){
Assert.assertEquals(1,instance.getRequestInterceptorCount());
Assert.assertEquals(0,instance.getRequestInterceptorCount());
}