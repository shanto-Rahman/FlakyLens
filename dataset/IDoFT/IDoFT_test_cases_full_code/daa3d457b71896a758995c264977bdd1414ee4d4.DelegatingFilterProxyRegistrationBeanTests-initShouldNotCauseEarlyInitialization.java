@Test public void initShouldNotCauseEarlyInitialization() throws Exception {
  this.applicationContext.registerBeanDefinition("mockFilter",new RootBeanDefinition(MockFilter.class));
  DelegatingFilterProxyRegistrationBean registrationBean=createFilterRegistrationBean();
  Filter filter=registrationBean.getFilter();
  filter.init(new MockFilterConfig());
  assertThat(mockFilterInitialized.get()).isNull();
  filter.doFilter(new MockHttpServletRequest(),new MockHttpServletResponse(),new MockFilterChain());
  assertThat(mockFilterInitialized.get()).isTrue();
}
