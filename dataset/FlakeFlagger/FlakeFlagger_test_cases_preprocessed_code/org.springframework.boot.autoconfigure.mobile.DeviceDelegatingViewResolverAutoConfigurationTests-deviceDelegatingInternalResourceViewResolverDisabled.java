@Test(expected=NoSuchBeanDefinitionException.class) public void deviceDelegatingInternalResourceViewResolverDisabled() throws Exception {
assertNotNull(this.context.getBean(InternalResourceViewResolver.class));
}