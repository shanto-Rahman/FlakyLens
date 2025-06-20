@Test public void deviceDelegatingInternalResourceViewResolverEnabled() throws Exception {
assertNotNull(internalResourceViewResolver);
assertNotNull(deviceDelegatingViewResolver);
assertTrue(deviceDelegatingViewResolver.getViewResolver() instanceof InternalResourceViewResolver);
assertTrue(deviceDelegatingViewResolver.getOrder() == internalResourceViewResolver.getOrder() - 1);
}