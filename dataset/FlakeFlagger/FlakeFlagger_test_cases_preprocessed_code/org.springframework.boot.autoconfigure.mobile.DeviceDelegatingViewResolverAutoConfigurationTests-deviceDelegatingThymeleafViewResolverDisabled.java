@Test(expected=NoSuchBeanDefinitionException.class) public void deviceDelegatingThymeleafViewResolverDisabled() throws Exception {
assertNotNull(this.context.getBean(InternalResourceViewResolver.class));
assertNotNull(this.context.getBean(ThymeleafViewResolver.class));
}