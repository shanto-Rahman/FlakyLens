@Test public void deviceDelegatingThymeleafViewResolverEnabled() throws Exception {
assertNotNull(thymeleafViewResolver);
assertNotNull(deviceDelegatingViewResolver);
assertTrue(deviceDelegatingViewResolver.getViewResolver() instanceof ThymeleafViewResolver);
assertNotNull(this.context.getBean(InternalResourceViewResolver.class));
assertNotNull(this.context.getBean(ThymeleafViewResolver.class));
assertTrue(deviceDelegatingViewResolver.getOrder() == thymeleafViewResolver.getOrder() - 1);
}