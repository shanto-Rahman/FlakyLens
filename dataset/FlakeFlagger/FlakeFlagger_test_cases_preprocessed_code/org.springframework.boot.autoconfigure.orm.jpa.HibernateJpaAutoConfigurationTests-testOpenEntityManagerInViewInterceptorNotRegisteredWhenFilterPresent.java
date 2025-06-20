@Test public void testOpenEntityManagerInViewInterceptorNotRegisteredWhenFilterPresent() throws Exception {
assertEquals(0,getInterceptorBeans(context).length);
}