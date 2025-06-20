@Test public void testOpenEntityManagerInViewInterceptorCreated() throws Exception {
assertNotNull(context.getBean(OpenEntityManagerInViewInterceptor.class));
}