@Test public void sitePreferenceMethodArgumentResolverEnabled() throws Exception {
assertNotNull(this.context.getBean(SitePreferenceHandlerMethodArgumentResolver.class));
}