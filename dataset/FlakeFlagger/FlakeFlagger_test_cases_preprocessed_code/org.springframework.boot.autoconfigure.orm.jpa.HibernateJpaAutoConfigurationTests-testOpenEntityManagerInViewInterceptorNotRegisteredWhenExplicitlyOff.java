@Test public void testOpenEntityManagerInViewInterceptorNotRegisteredWhenExplicitlyOff() throws Exception {
assertEquals(0,getInterceptorBeans(context).length);
}